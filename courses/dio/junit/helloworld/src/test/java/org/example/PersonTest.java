package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonTest {

    @Test
    void shouldCalculateAgeCorrectly() {
        Person joao = new Person("João", LocalDate.of(2000, 1, 13));

        Assertions.assertEquals(23, joao.getAge()); // Espera que seja 23 quando chamar o método getAge
        // Verifica se a função getAge de Person retorna o valor correto de acordo com a data de nascimento da pessoa
    }

    @Test
    void ShouldReturnIfItsOfLegalAge() {
        Person joao = new Person("João", LocalDate.of(2000, 1, 13));
        Assertions.assertTrue(joao.isOfLegalAge()); // Assert True para trabalhar com booleans

        Person ana = new Person("Ana", LocalDate.of(2014, 5, 15));
        Assertions.assertFalse(ana.isOfLegalAge()); // Assert False para que o teste passe
    }
}
