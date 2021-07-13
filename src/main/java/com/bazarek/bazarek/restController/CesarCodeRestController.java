package com.bazarek.bazarek.restController;

import com.bazarek.bazarek.cezar.CesarCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class CesarCodeRestController {

    @Autowired
    CesarCode code;

    public CesarCodeRestController(final CesarCode code) {
        this.code = code;
    }
    @GetMapping("/decode/{text}")
    public String decodeTextOnCesarCode(@PathVariable String text){
        return CesarCode.decode(text);
    }
}
