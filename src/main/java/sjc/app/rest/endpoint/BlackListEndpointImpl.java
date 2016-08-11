package sjc.app.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sjc.app.constant.Constant;
import sjc.app.rest.response.PaginationResponseSuccessful;
import sjc.app.rest.response.ResponseSuccessful;
import sjc.app.rest.response.impl.PaginationResponseImpl;
import sjc.app.rest.response.impl.ResponseImpl;
import sjc.app.service.BlackListService;

@Controller
@RequestMapping("/blacklist")
public class BlackListEndpointImpl
{
    @Autowired
    private BlackListService blackListService;
    private PaginationResponseSuccessful paginationResponse=new PaginationResponseImpl();
    private ResponseSuccessful response=new ResponseImpl();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PaginationResponseSuccessful getBlackList(@RequestParam Long userId, @RequestParam Integer offset, @RequestParam Integer limit)
    {
        paginationResponse.setEntity(blackListService.getBlackList(userId, offset, limit));
        paginationResponse.addMetadata(Constant.OFFSET,offset.toString());
        paginationResponse.addMetadata(Constant.LIMIT,limit.toString());
        paginationResponse.addMetadata(Constant.COUNT,blackListService.getCountBlackUser(userId).toString());
        return paginationResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseSuccessful addBlackList(@RequestParam Long ownerId, @RequestParam Long blackUserId)
    {
        blackListService.addBlackList(ownerId, blackUserId);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseSuccessful deleteBlackList(Long ownerId, Long blackUserId)
    {
        blackListService.deleteBlackList(ownerId, blackUserId);
        return response;
    }
}
