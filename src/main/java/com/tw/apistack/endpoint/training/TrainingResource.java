package com.tw.apistack.endpoint.training;

import com.tw.apistack.Utils;
import com.tw.apistack.endpoint.todo.dto.ResourceWithUrl;
import com.tw.apistack.endpoint.training.dto.Training;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jxzhong on 2017/7/3.
 */
@RestController
@RequestMapping(value = "/trainings")
public class TrainingResource {

    @PostMapping(headers = {"Content-type=application/json"})
    public HttpEntity<ResourceWithUrl> addNewTraining(
            @RequestParam(value = "session", required = false) String session,
            @RequestBody Training training) {

        if(!"12345abcde".equals(session)){
            ResourceWithUrl unauthorized = new ResourceWithUrl<>(
                    "unauthorized",
                    404,
                    training,
                    "");
            ResponseEntity responseEntity = new ResponseEntity(unauthorized, HttpStatus.UNAUTHORIZED);
            return responseEntity;
        }

        if(Utils.isEmpty(training.getName()) ||
                Utils.isEmpty(training.getDesc()) ||
                Utils.isEmpty(training.getStartTime()) ||
                Utils.isEmpty(training.getEndTme()) ||
                Utils.isEmpty(training.getPics())) {
            return ResponseEntity.badRequest().body(new ResourceWithUrl<>("missing required params", 400, null, ""));
        }

        ResponseEntity resourceWithUrlResponseEntity = ResponseEntity.ok("");
        return resourceWithUrlResponseEntity;
    }

}
