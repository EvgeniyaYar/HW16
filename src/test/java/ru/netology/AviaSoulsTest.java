package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaSoulsTest {
    @Test
    public void shouldCompareByPrice() {
        Ticket ticket1 = new Ticket("Moscow", "Vladivostok", 40_000, 5, 8);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 25_000, 6, 9);
        Ticket ticket3 = new Ticket("Moscow", "Vladivostok", 30_000, 7, 10);
        Ticket ticket4 = new Ticket("Moscow", "Vladivostok", 30_000, 8, 11);

        assert ticket1.compareTo(ticket2) > 0;
        assert ticket3.compareTo(ticket1) < 0;
        assert ticket4.compareTo(ticket3) == 0;
    }

    @Test
    public void shouldSortByPrice() {
        Ticket ticket1 = new Ticket("Moscow", "Vladivostok", 40_000, 5, 8);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 25_000, 6, 9);
        Ticket ticket3 = new Ticket("Moscow", "Vladivostok", 30_000, 7, 10);
        Ticket ticket4 = new Ticket("Moscow", "Vladivostok", 32_000, 8, 11);
        Ticket ticket5 = new Ticket("Moscow", "Vladivostok", 27_000, 9, 12);

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] actual = {ticket2, ticket5, ticket3, ticket4, ticket1};
        Ticket[] expected = avia.search("Moscow", "Vladivostok");
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldCompareByTimeOfFlight() {
        Ticket ticket1 = new Ticket("Moscow", "Vladivostok", 40_000, 13, 18);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 25_000, 11, 20);
        Ticket ticket3 = new Ticket("Moscow", "Vladivostok", 30_000, 13, 22);
        Ticket ticket4 = new Ticket("Moscow", "Vladivostok", 30_000, 4, 11);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        assertTrue(ticketTimeComparator.compare(ticket1, ticket2) < 0);
        assertTrue(ticketTimeComparator.compare(ticket3, ticket4) > 0);
        assertTrue(ticketTimeComparator.compare(ticket2, ticket3) == 0);

    }

    @Test
    public void shouldSortByTime() {
        Ticket ticket1 = new Ticket("Moscow", "Vladivostok", 40_000, 13, 18);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 25_000, 13, 21);
        Ticket ticket3 = new Ticket("Moscow", "Vladivostok", 30_000, 13, 22);
        Ticket ticket4 = new Ticket("Moscow", "Vladivostok", 32_000, 13, 19);
        Ticket ticket5 = new Ticket("Moscow", "Vladivostok", 27_000, 13, 20);

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actual = {ticket1, ticket4, ticket5, ticket2, ticket3};
        Ticket[] expected = avia.searchAndSortBy("Moscow", "Vladivostok", ticketTimeComparator);
        Assertions.assertArrayEquals(actual, expected);
    }
}
