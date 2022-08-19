package EncapsulationFootballTeamGeneratorEx05OK;

public class Player {

        private String name;
        private int endurance;
        private int sprint;
        private int dribble;
        private int passing;
        private int shooting;

        public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
            this.setName(name);
            this.setEndurance(endurance);
            this.setSprint(sprint);
            this.setDribble(dribble);
            this.setPassing(passing);
            this.setShooting(shooting);
        }

        public String getName() {
            return this.name;
        }

        private void setName(final String name) {
            throwException(name);
            this.name = name;
        }

        private void setEndurance(final int endurance) {
            throwException(endurance, "Endurance should be between 0 and 100.");
            this.endurance = endurance;
        }

        private void setSprint(final int sprint) {
            throwException(sprint, "Sprint should be between 0 and 100.");
            this.sprint = sprint;
        }

        private void setDribble(final int dribble) {
            throwException(dribble, "Dribble should be between 0 and 100.");
            this.dribble = dribble;
        }

        private void setPassing(final int passing) {
            throwException(passing, "Passing should be between 0 and 100.");
            this.passing = passing;
        }

        public int getShooting() {
            return this.shooting;
        }

        private void setShooting(final int shooting) {
            throwException(shooting, "Shooting should be between 0 and 100.");
            this.shooting = shooting;
        }

        public double overallSkillLevel() {
            return (endurance + sprint + dribble + passing + shooting) / 5.00;
        }

        private void throwException(final int x, final String message) {
            if (x < 0 || x > 100) {
                throw new IllegalArgumentException(message);
            }
        }

        private void throwException(final String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("A name should not be empty.");
            }
        }
    }
