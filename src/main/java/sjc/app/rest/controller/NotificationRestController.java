package sjc.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sjc.app.model.vo.NotificationVO;
import sjc.app.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationRestController
{
    @Autowired
    private NotificationService notificationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public void addTokenForNotification(@RequestBody NotificationVO notification)
    {
        notificationService.addTokenFromNotification(SecurityContextHolder.getContext().getAuthentication().getName(), notification);
    }
}
