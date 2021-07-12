package ru.netology.manager;

import ru.netology.domain.FlyChoice;
import ru.netology.repository.ChoiceRepository;

import java.util.Arrays;

public class ChoiceManager {
    private ChoiceRepository choiceRepository;

    ChoiceManager(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public void add(FlyChoice flyChoice) {
        choiceRepository.save(flyChoice);
    }

    public FlyChoice[] findAll(String from, String to) {
        FlyChoice[] result = new FlyChoice[0];
        for (FlyChoice flyChoice : choiceRepository.findAll()) {
            if (flyChoice.getAirportFrom().equalsIgnoreCase(from) & flyChoice.getAirportTo().equalsIgnoreCase(to)) {
                FlyChoice[] tmp = new FlyChoice[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flyChoice;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
