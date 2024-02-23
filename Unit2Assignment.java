import java.util.Random;

public class Unit2Assignment {

    enum State {//define weather states 
        CLEAR //Example: CLOUDY, RAINING, SEVERE_WEATHER
    }

    enum Event {//define events 
        //Example: GETTING_WARMER, GETTING_COLDER, HUMIDITY_INCREASING, WIND_INCREASING
    }

    private static State currentState = State.CLEAR;
    public static void main(String[] args) {
        simulateWeatherCycle();
    }

    private static void simulateWeatherCycle() {
        Random random = new Random();

        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day + ":");
            for (int event = 1; event <= 5; event++) {
                int transition = random.nextInt(3);
                if (transition == 0 && currentState.ordinal() > 0) {
                    currentState = State.values()[currentState.ordinal() - 1];
                } else if (transition == 2 && currentState.ordinal() < State.values().length - 1) {
                    currentState = State.values()[currentState.ordinal() + 1];
                }

                System.out.println("Event " + event + ": " + currentState);
            }
            System.out.println();
        }
    }
}

