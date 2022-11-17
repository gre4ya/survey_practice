import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {
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
        Scanner input = new Scanner(System.in);
        List<Participant> participantList = new ArrayList<>();

        do {

            System.out.println(SurveyQuestions.askToJoin);
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("Y") ||
                    answer.equalsIgnoreCase("yes")) {

                Participant participant = new Participant();

                System.out.println(SurveyQuestions.askName);
                participant.name = input.nextLine();

                System.out.println(SurveyQuestions.askAge);
                participant.age = input.nextInt();
                input.nextLine();

                System.out.println(SurveyQuestions.askGender);
                participant.gender = input.next().toUpperCase().charAt(0);
                input.nextLine();

                participantList.add(participant);

                if (participant.gender == 'M') Participant.addMaleParticipants();
                else if (participant.gender == 'F') Participant.addFemaleParticipants();
                else System.out.println("Invalid input");

                Participant.addParticipants();
            }
        }
        while (Participant.totalNumberOfParticipants < 3);


//        for (int i = 0; i < 3; i++) {
//            System.out.println(SurveyQuestions.askToJoin);
//            String answer = input.nextLine();
//              if(answer.equalsIgnoreCase("Y") ||
//                      answer.equalsIgnoreCase("yes")){
//
//                Participant participant = new Participant();
//
//                System.out.println(SurveyQuestions.askName);
//                participant.name = input.nextLine();
//
//                System.out.println(SurveyQuestions.askAge);
//                participant.age = input.nextInt();
//
//                System.out.println(SurveyQuestions.askGender);
//                participant.gender = input.next().toUpperCase().charAt(0);
//                input.nextLine();
//
//                participantList.add(participant);
//
//                  if(participant.gender == 'M') Participant.addMaleParticipants();
//                  else if(participant.gender == 'F') Participant.addFemaleParticipants();
//                  else System.out.println("Invalid input");
//
//                Participant.addParticipants();
//            }
//            else if(answer.equalsIgnoreCase("N") ||
//                      answer.equalsIgnoreCase("no")) i--;
//        }

        participantList.forEach(System.out::println);
        System.out.println("The total number of male participants is = " +
                Participant.totalNumberOfMaleParticipants);
        System.out.println("The total number of female participants is = " +
                Participant.totalNumberOfFemaleParticipants);
        System.out.println("The age of the youngest person is = " +
                Math.min(Math.min(participantList.get(0).age, participantList.get(1).age), participantList.get(2).age));
        System.out.println("The age of the eldest person is = " +
                Math.max(Math.max(participantList.get(0).age, participantList.get(1).age), participantList.get(2).age));

    }

}
