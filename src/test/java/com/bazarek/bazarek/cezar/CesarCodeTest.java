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
    void shouldDecodeStringTextWithCezarCode() {
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
    void shouldEncodeStringTextWithCezarCode() {
        //given
        CesarCode code = new CesarCode();
        String kamil = CesarCode.decode("Kamil");
        System.out.println("Zakodowany Kamil: " + kamil);

        //when
        String encode = CesarCode.encode("HDPLO");
        System.out.println("Rozkodowany Kamil: "+encode);

        //then

        assertThat(kamil).isEqualTo("HDPLO");
        assertThat(encode).isEqualTo("KGSOR")
                .endsWith("OR")
                .isEqualToIgnoringCase("kgsor");

    }
}
