package com.bazarek.bazarek.cezar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CesarCodeTest {

    @Test
    void shouldDecodeString() {
        //given
        CesarCode code = new CesarCode();
        String elmo = CesarCode.decode("Elmo");
        System.out.println("zakodowany tekst to: " + elmo);

        //then
        assertThat(elmo).isNotEmpty();
        assertThat(elmo).isEqualTo("BOPR")
                .startsWith("BO")
                .endsWith("PR")
                .isEqualToIgnoringCase("bopr");
    }

    @Test
    void valid() {
    }
}
