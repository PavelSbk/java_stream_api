package org.stream_api.theory.generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <T extends Participant> можно создать только экземпляры классов которые наследуют Participant
 */

public class Team <T extends Participant>{

    private String name;

    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println(((Participant) participant).getName() + " just joined " + this.name);
    }

    /**
     * (Team<T> team) - можно передать только команду типа Т, т.е. одинаковых классов
     *
     */

    public void playWith(Team<T> team) {
        String winner;
        Random random = new Random();
        int i = random.nextInt(2);
        winner = i == 0 ? this.name : team.name;
        System.out.println(winner);
    }
}
