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
        String kamil = CesarCode.decode("kamil");
        System.out.println("Zakodowany kamil: " + kamil);
        //when

        String encode = CesarCode.encode("ndplo");
        System.out.println("Odkodowany NDPLO: "+ encode);

        //then

        assertThat(kamil).isEqualTo("NDPLO");
        assertThat(encode).isEqualToIgnoringCase("KAMIL")
                .endsWith("MIL");
        assertThat(encode).isEqualTo("KAMIL");
    }
}
