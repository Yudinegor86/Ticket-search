package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlyChoice;
import ru.netology.repository.ChoiceRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlyChoiceManagerTest {

    ChoiceRepository ChoiceRepository = new ChoiceRepository();
    ChoiceManager ChoiceManager = new ChoiceManager(ChoiceRepository);

    FlyChoice likeTicket1 = new FlyChoice(0, 2000, "SvN", "BGN", 90);
    FlyChoice likeTicket2 = new FlyChoice(1, 2500, "svn", "THG", 140);
    FlyChoice likeTicket3 = new FlyChoice(2, 810, "GFH", "FRD", 100);
    FlyChoice likeTicket4 = new FlyChoice(3, 980, "SVN", "BGN", 110);
    FlyChoice likeTicket5 = new FlyChoice(4, 2200, "BGN", "SVN", 130);
    FlyChoice likeTicket6 = new FlyChoice(5, 4000, "SVN", "BGN", 150);

    @Test
    void findAllMany() {
        ChoiceManager.add(likeTicket1);
        ChoiceManager.add(likeTicket2);
        ChoiceManager.add(likeTicket3);
        ChoiceManager.add(likeTicket4);
        ChoiceManager.add(likeTicket5);
        ChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{likeTicket4, likeTicket1, likeTicket6}, ChoiceManager.findAll("svn", "bgn"));
    }

    @Test
    void findAllOne() {
        ChoiceManager.add(likeTicket1);
        ChoiceManager.add(likeTicket2);
        ChoiceManager.add(likeTicket3);
        ChoiceManager.add(likeTicket4);
        ChoiceManager.add(likeTicket5);
        ChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{likeTicket2}, ChoiceManager.findAll("SVN", "THG"));
    }

    @Test
    void findAllNothing() {
        ChoiceManager.add(likeTicket1);
        ChoiceManager.add(likeTicket2);
        ChoiceManager.add(likeTicket3);
        ChoiceManager.add(likeTicket4);
        ChoiceManager.add(likeTicket5);
        ChoiceManager.add(likeTicket6);

        assertArrayEquals(new FlyChoice[]{}, ChoiceManager.findAll("cvb", "jop"));
    }
}