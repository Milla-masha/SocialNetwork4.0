package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.exception.NotFoundExseption;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.DialogService;
import sjc.app.service.MessageService;

@Controller
@RequestMapping("/dialogs")
public class DialogRestController
{
    @Autowired
    private DialogService dialogService;
    @Autowired
    private MessageService messageService;
    private PaginationResponseSuccessful paginationResponse = new PaginationResponseImpl();
    private ResponseSuccessful response = new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getDialogs(@RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(dialogService.getDialogs(SecurityContextHolder.getContext().getAuthentication().getName(), offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET, offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT, limit.toString());
        paginationResponse.addMetadata(Constant.COUNT, dialogService.getCountDialogsFromUser(SecurityContextHolder.getContext().getAuthentication().getName()).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "/{dialogId}/messages")
    @ResponseBody
    public PaginationResponseSuccessful getMessages(@PathVariable Long dialogId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(messageService.getMessages(SecurityContextHolder.getContext().getAuthentication().getName(), dialogId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET, offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT, limit.toString());
        paginationResponse.addMetadata(Constant.COUNT, messageService.getCountMassagesFromDialog(dialogId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value="/find")
    @ResponseBody
    public ResponseSuccessful getDialogId(@RequestParam Long userId) throws NotFoundExseption
    {
        response.setEntity(dialogService.getDialogIdByUser(SecurityContextHolder.getContext().getAuthentication().getName(),userId));
        return response;
    }
}
