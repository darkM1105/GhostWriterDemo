package game_resources.processing;

import game_resources.entity.GameSession;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compressor {

    private Integer[] sessionArray = new Integer[270];
    private String[] wordListArray = new String[30];

    public int process(Integer[] sessionArray, int wordListId, String username) {

        String filePath;
        int record;

        this.sessionArray = sessionArray;
        filePath = createFile("game_session", wordListId, username);
        GameSession gameSession = new GameSession(0, wordListId, filePath);
        record = GameDAO.getPublicDAO().createGameSession(gameSession);

        return record;

    }

    public int process(String[] wordListArray) {

        String filePath;
        int record;

        this.wordListArray = wordListArray;
        filePath = createFile("word_list", 0, "");
        WordList wordList = new WordList(0, filePath);
        record = GameDAO.getPublicDAO().createWordList(wordList);

        return record;

    }

    private String createFile(String fileType, int wordListId, String username) {

        String finalName = "";
        String directory = "";
        int listId = wordListId;
        String userName = username;
        String tempName;

        if (fileType.equals("game_session")) {

            directory = "GameSessions\\list" + listId;

        } else if (fileType.equals("word_list")) {

            directory = "WordLists";
            listId = GameDAO.getPublicDAO().getNextListId();

        }

        tempName = "C:\\10DashingDigitsDB\\" + directory + "\\" + createTimeStampName() + listId + ".txt";

        try(PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(tempName)))) {

            if (fileType.equals("game_session")) {

                for (int i = 0; i < sessionArray.length; i++) {

                    printer.print(sessionArray[i] + " ");

                    if (i != (sessionArray.length - 1)) {

                        printer.println();

                    } else if (i == (sessionArray.length - 1)) {

                        printer.println(userName);

                    }

                }

                finalName = tempName;

            } else if (fileType.equals("word_list")) {

                for (int i = 1; i <= 3; i++) {

                    for(int j = 1; j <= 10; j++) {

                        printer.print(wordListArray[i] + " ");

                    }

                    printer.println();

                }

                finalName = tempName;

                printer.print(finalName + " ");

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return finalName;

    }

    private String createTimeStampName() {

        String timeStampName;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        timeStampName = sdf.format(date);

        timeStampName = timeStampName.replaceFirst("/", "MM");
        timeStampName = timeStampName.replaceFirst("/", "dd");
        timeStampName = timeStampName.replaceFirst(" ", "yyyy");
        timeStampName = timeStampName.replaceFirst(":", "hh");
        timeStampName = timeStampName.replaceFirst(":", "mm");
        timeStampName = timeStampName.replaceFirst(" ", "ss");

        return timeStampName;

    }

}