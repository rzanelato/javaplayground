package silly;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventTalk {

    private static final int MAX_MORNING_MINUTES = 180;
    private static final int MAX_AFTERNOON_MINUTES = 240;

    private List<Talk> talks;
    private List<Talk> morningEvents;
    private List<Talk> afternoonEvents;
    private List<String> dayEvent;
    private LocalTime eventStart = LocalTime.of(9, 0);

    public EventTalk(List<Talk> talks) {
        this.talks = new LinkedList<>(talks);
        generateLists();
    }

    private void generateLists() {
        generateMorning();
        generateAfternoon();
        generateDayEvent();
    }

    private void generateMorning() {
        this.morningEvents = new LinkedList<>();
        final var totalDuration = new AtomicInteger(0);
        while (totalDuration.intValue() < MAX_MORNING_MINUTES || totalDuration.intValue() > MAX_MORNING_MINUTES) {
            Optional.of(totalDuration)
                    .filter(duration -> duration.intValue() < MAX_MORNING_MINUTES)
                    .ifPresentOrElse(duration -> addRandomTalk(morningEvents, duration)
                            , () -> cleanEventList(morningEvents, totalDuration));
        }
    }

    private void addRandomTalk(List<Talk> listEvent, AtomicInteger totalDuration) {
        var randomIndex = new Random().nextInt(talks.size());
        totalDuration.getAndAdd(talks.get(randomIndex).getDuration());
        listEvent.add(talks.get(randomIndex));
        talks.remove(randomIndex);

    }

    private void cleanEventList(List<Talk> listEvent, AtomicInteger totalDuration) {
        talks.addAll(listEvent);
        listEvent.clear();
        totalDuration.set(0);
    }

    private void generateAfternoon() {
        this.afternoonEvents = new LinkedList<>();
        final var totalDuration = new AtomicInteger(0);

        while (totalDuration.intValue() < MAX_AFTERNOON_MINUTES || totalDuration.intValue() > MAX_AFTERNOON_MINUTES) {
            Optional.of(totalDuration)
                    .filter(duration -> duration.intValue() < MAX_AFTERNOON_MINUTES)
                    .ifPresentOrElse(duration -> addRandomTalk(afternoonEvents, duration)
                            , () -> removeLastTalk(afternoonEvents, totalDuration));
        }
    }

    private void removeLastTalk(List<Talk> listEvent, AtomicInteger totalDuration) {
        var lastIndex = listEvent.size() - 1;
        talks.add(listEvent.get(lastIndex));
        listEvent.remove(lastIndex);
        totalDuration.set(MAX_AFTERNOON_MINUTES);
    }

    private void generateDayEvent() {
        dayEvent = new ArrayList<>();
        var lunch = new Talk("Lunch", 60);
        var networkingEvent = new Talk("Networking event", 30);

        morningEvents.stream().map(this::convertTime).forEach(dayEvent::add);
        Optional.of(lunch)
				.map(this::convertTime)
				.ifPresent(dayEvent::add);
        afternoonEvents.stream()
					   .map(this::convertTime)
					   .forEach(dayEvent::add);
        Optional.of(networkingEvent)
				.map(this::convertTime)
				.ifPresent(dayEvent::add);
    }

    private String convertTime(Talk talk) {
        var time = getTimeString(eventStart, talk.getName());
        eventStart = eventStart.plusMinutes(talk.getDuration());
        return time;
    }

    private String getTimeString(LocalTime time, String name) {
        return time.format(DateTimeFormatter.ofPattern("hh:mma")).toUpperCase() + " " + name;
    }

    public List<Talk> getMorningEvents() {
        return this.morningEvents;
    }

    public List<Talk> getAfternoonEvents() {
        return this.afternoonEvents;
    }

    public List<String> getDayEvent() {
        return this.dayEvent;
    }

    public static void main(String[] args) {
        var textTalks = "Writing Fast Tests Against Enterprise Rails 60min\n" +
                "Overdoing it in Python 45min\n" +
                "Lua for the Masses 30min\n" +
                "Ruby Errors from Mismatched Gem Versions 45min\n" +
                "Common Ruby Errors 45min\n" +
                "Rails for Python Developers lightning\n" +
                "Communicating Over Distance 60min\n" +
                "Accounting-Driven Development 45min\n" +
                "Woah 30min\n" +
                "Sit Down and Write 30min\n" +
                "Pair Programming vs Noise 45min\n" +
                "Rails Magic 60min\n" +
                "Ruby on Rails: Why We Should Move On 60min\n" +
                "Clojure Ate Scala (on my project) 45min\n" +
                "Programming in the Boondocks of Seattle 30min\n" +
                "Ruby vs. Clojure for Back-End Development 30min\n" +
                "Ruby on Rails Legacy App Maintenance 60min\n" +
                "A World Without HackerNews 30min\n" +
                "User Interface CSS in Rails Apps 30min";

        var listTalk = getTalksFromText(textTalks);
        var event = new EventTalk(listTalk);
        var morning = event.getMorningEvents();
        var afternoon = event.getAfternoonEvents();
        var dayEvent = event.getDayEvent();

        System.out.println("Tamanho Morning: " + morning.size());
        System.out.println("Tamanho Afternoon: " + afternoon.size());
        System.out.println("\nMorning ->");
        morning.forEach(System.out::println);
        System.out.println("\nAfternoon ->");
        afternoon.forEach(System.out::println);
        System.out.println("\nDay Event ->");
        dayEvent.forEach(System.out::println);

    }

    private static List<Talk> getTalksFromText(String text) {
        return Stream.of(text.split("\n")).map(Talk::new).collect(Collectors.toList());
    }

}