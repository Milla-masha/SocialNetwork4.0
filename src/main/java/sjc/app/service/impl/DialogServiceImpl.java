package sjc.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjc.app.constant.Constant;
import sjc.app.dao.DialogDao;
import sjc.app.dao.MessageDao;
import sjc.app.dao.UserDao;
import sjc.app.model.entity.DialogEntityImpl;
import sjc.app.model.entity.MessageEntityImpl;
import sjc.app.model.entity.UserEntityImpl;
import sjc.app.model.vo.DialogVO;
import sjc.app.model.vo.MessageVO;
import sjc.app.model.vo.UserSmallVO;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.service.DialogService;

import java.util.ArrayList;
import java.util.List;

@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
@Service
public class DialogServiceImpl implements DialogService
{
    @Autowired
    private DialogDao dialogDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OnlineUser onlineUserService;
    @Autowired
    private MessageDao messageDao;

    @Override
    public List<DialogVO> getDialogs(String login, int offset, int limit)
    {

        UserEntityImpl user = userDao.findByName(login);
        List<DialogEntityImpl> dialogEntities = dialogDao.getDialogsByUser(user.getId(), offset, limit);

        if (dialogEntities == null)
        {
            return null;
        }

        List<DialogVO> dialogs = new ArrayList<>();
        for (DialogEntityImpl dialogEntity : dialogEntities)
        {
            List<UserSmallVO> usersVO = new ArrayList<>();
            List<UserEntityImpl> userEntities = dialogEntity.getUsers();

            userEntities.remove(user);
            for (UserEntityImpl usersEntity : userEntities)
            {
                UserSmallVO userVO = new UserSmallVO();
                userVO.setId(usersEntity.getId());
                userVO.setAvatar(usersEntity.getAvatar().getUrl());
                userVO.setName(usersEntity.getName());
                userVO.setLastName(usersEntity.getLastName());
                userVO.setOnline(onlineUserService.isOnline(usersEntity.getLogin()));
                usersVO.add(userVO);
            }
            if (!dialogEntity.getMessages().isEmpty())
            {
                MessageEntityImpl lastMessageEntity;
                MessageVO messageVO = new MessageVO();
                lastMessageEntity = messageDao.getLastMessageByDialog(dialogEntity.getId());
                messageVO.setMessage(lastMessageEntity.getText());
                messageVO.setSenderId(lastMessageEntity.getSender().getId());
                messageVO.setId(lastMessageEntity.getId());
                DialogVO dialog = new DialogVO();

                dialog.setId(dialogEntity.getId());
                dialog.setLastMessage(messageVO);
                userEntities.add(user);
                dialog.setReciver(usersVO);
                dialogs.add(dialog);
            }else{
                MessageVO messageVO = new MessageVO();
                DialogVO dialog = new DialogVO();

                dialog.setId(dialogEntity.getId());
                dialog.setLastMessage(messageVO);
                userEntities.add(user);
                dialog.setReciver(usersVO);
                dialogs.add(dialog);
            }
  }
        return dialogs;
    }

    @Override
    public Long getCountDialogsFromUser(String login)
    {
        return dialogDao.getCountDialogsByUser(userDao.findByName(login).getId());
    }

    @Override
    public Long getDialogIdByUser(String login, Long userId) throws NotFoundExseption
    {
        UserEntityImpl user = userDao.findByName(login);
        UserEntityImpl userTo = userDao.findById(userId);
        if (userTo == null)
        {
            throw new NotFoundExseption(Constant.USER + userId + Constant.MESSAGE_NOT_FOUND);
        }
        for (DialogEntityImpl dialog : user.getDialogs())
        {
            if (dialog.getUsers().contains(userTo))
            {
                return dialog.getId();
            }
        }
        DialogEntityImpl dialog = new DialogEntityImpl();
        List<UserEntityImpl> users = new ArrayList<>();
        users.add(userTo);
        users.add(user);
        dialog.getUsers().addAll(users);
        return dialogDao.save(dialog).getId();
    }
}
