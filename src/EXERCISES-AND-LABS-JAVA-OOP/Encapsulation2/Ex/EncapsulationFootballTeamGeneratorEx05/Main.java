package Encapsulation2.Ex.EncapsulationFootballTeamGeneratorEx05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;

    public class Main {
        public static void main(String[] args) throws IOException {

            final var reader = new BufferedReader(new InputStreamReader(System.in));
            final var sb = new StringBuilder();
            var input = reader.readLine();
            Map<String, Team> teams = new LinkedHashMap<>();

            while (!input.equals("END")) {
                var tokens = input.split(";");
                var command = tokens[0];
                try {
                    switch (command) {
                        case "Team":
                            teams.putIfAbsent(tokens[1], new Team(tokens[1]));
                            break;
                        case "Add":
                            addPlayer(sb, teams, tokens);
                            break;
                        case "Remove":
                            removePlayer(sb, teams, tokens);
                            break;
                        case "Rating":
                            getRating(sb, teams, tokens);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    sb.append(e.getMessage()).append(lineSeparator());
                }
                input = reader.readLine();
            }
            System.out.println(sb.toString().trim());
        }

        private static void getRating(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
            sb.append(teams.containsKey(tokens[1])
                    ? format("%s - %d%n", tokens[1], (int) Math.round(teams.get(tokens[1]).getRating()))
                    : format("Team %s does not exist.%n", tokens[1]));
        }

        private static void removePlayer(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
            if (teams.get(tokens[1]).hasPlayer(tokens[2])) {
                teams.get(tokens[1]).removePlayer(tokens[2]);
            } else {
                sb.append(format("Player %s is not in %s team.%n", tokens[2], tokens[1]));
            }
        }

        private static void addPlayer(StringBuilder sb, Map<String, Team> teams, String[] tokens) {
            if (teams.containsKey(tokens[1])) {
                final var player = new Player(
                        tokens[2],
                        parseInt(tokens[3]),
                        parseInt(tokens[4]),
                        parseInt(tokens[5]),
                        parseInt(tokens[6]),
                        parseInt(tokens[7]));
                teams.get(tokens[1]).addPlayer(player);
            } else {
                sb.append(format("Team %s does not exist.%n", tokens[1]));
            }
        }
    }






