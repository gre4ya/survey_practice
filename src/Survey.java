import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */

//        Participant participant1 = new Participant();
//        Participant participant2 = new Participant();
//        Participant participant3 = new Participant();

        List<Participant> participantList = new ArrayList<>();
//        participantList.add(participant1);
//        participantList.add(participant2);
//        participantList.add(participant3);
        //participantList.size();
        for (int i = 1; i <= 3; i++) {
            System.out.println(SurveyQuestions.askToJoin);
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase("Y")){
                Participant participant = new Participant();
                System.out.println(SurveyQuestions.askName);
                participant.name = input.nextLine();
                System.out.println(SurveyQuestions.askAge);
                participant.age = input.nextByte();
                System.out.println(SurveyQuestions.askGender);
                participant.gender = input.next();
                input.nextLine();
                participantList.add(participant);
                if(participant.gender.equalsIgnoreCase("M")) Participant.addMaleParticipants();
                else if(participant.gender.equalsIgnoreCase("F")) Participant.addFemaleParticipants();
                else System.out.println("Invalid input");
                Participant.addParticipants();
            }
            else if(answer.equalsIgnoreCase("N")) i--;
        }
        participantList.forEach(System.out::println);
        System.out.println("The total number of male participants is = " +
                Participant.totalNumberOfParticipants);
        System.out.println("The total number of female participants is = " +
                Participant.totalNumberOfFemaleParticipants);
        System.out.println("The age of the youngest person is = " +
                Math.min(Math.min(participantList.get(0).age, participantList.get(1).age), participantList.get(2).age));
        System.out.println("The age of the eldest person is = " +
                Math.max(Math.max(participantList.get(0).age, participantList.get(1).age), participantList.get(2).age));

    }

}
