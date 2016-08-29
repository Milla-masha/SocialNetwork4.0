package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.model.entity.DialogEntityImpl;
import sjc.app.model.entity.MessageEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.MessageDialogVO;
import sjc.app.model.vo.MessageVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.repository.dao.DialogDao;
import sjc.app.repository.dao.MessageDao;
import sjc.app.repository.dao.UserDao;
import sjc.app.service.MessageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private DialogDao dialogDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OnlineUser onlineUserService;

    @Override
    public MessageDialogVO getMessages(String login, Long dialogId, int offset, int limit)
    {
        List<MessageEntityImpl> messagesEntity = messageDao.getMessageByDialog(dialogId, offset, limit);
        if (messagesEntity == null)
        {
            return null;
        }
        if (messagesEntity.size() == 0)
        {
            return null;
        }
        UserEntityImpl owner = userDao.findByName(login);
        MessageDialogVO messageVO = new MessageDialogVO();
        UserSmallVO ownerVO = new UserSmallVO();
        ownerVO.setName(owner.getName());
        ownerVO.setId(owner.getId());
        ownerVO.setAvatar(owner.getAvatar().getUrl());
        ownerVO.setLastName(owner.getLastName());
        ownerVO.setOnline(onlineUserService.isOnline(owner.getLogin()));
        messageVO.setOwner(ownerVO);
        List<MessageVO> messagesVO = new ArrayList<>(0);
        for (MessageEntityImpl messageEntity : messagesEntity)
        {
            MessageVO messVO = new MessageVO();
            messVO.setId(messageEntity.getId());
            messVO.setText(messageEntity.getText());
            messVO.setSenderId(messageEntity.getSender().getId());
            messagesVO.add(messVO);
        }
        messageVO.setMessages(messagesVO);
        if (messagesEntity.get(0) != null)
        {
            List<UserEntityImpl> users = messagesEntity.get(0).getDialog().getUsers();
            users.remove(owner);
            List<UserSmallVO> usersVO = new ArrayList<>(0);
            for (UserEntityImpl userEntity : users)
            {
                UserSmallVO userVO = new UserSmallVO();
                userVO.setId(userEntity.getId());
                userVO.setName(userEntity.getName());
                userVO.setLastName(userEntity.getLastName());
                userVO.setAvatar(userEntity.getAvatar().getUrl());
                userVO.setOnline(onlineUserService.isOnline(userEntity.getLogin()));
                usersVO.add(userVO);
            }
            messageVO.setReciver(usersVO);
        }
        return messageVO;
    }

    @Override
    public Long getCountMassagesFromDialog(Long dialogId)
    {
        return messageDao.getCountMessagesByDialog(dialogId);
    }

    @Override
    public void addMessage(String text, Long userId, Long dialogId)
    {
        DialogEntityImpl dialogEntity = dialogDao.findById(dialogId);
        if (dialogEntity == null)
        {
            return;
        }
        UserEntityImpl user = userDao.findById(userId);
        if (user == null)
        {
            return;
        }
        MessageEntityImpl messageEntity = new MessageEntityImpl();
        messageEntity.setDialog(dialogEntity);
        messageEntity.setText(text);
        messageEntity.setSender(user);
        messageEntity.setDate(new Date());
        dialogEntity.getMessages().add(messageEntity);
        dialogDao.update(dialogEntity);
    }
}
