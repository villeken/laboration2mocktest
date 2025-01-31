package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class BookingSystemTest {

    @Mock
    private TimeProvider timeProvider;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private NotificationService notificationService;

    private BookingSystem bookingSystem;

    private Room room;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookingSystem = new BookingSystem(timeProvider, roomRepository, notificationService);

        room = new Room("1", "Room 1");
        when(roomRepository.findById("1")).thenReturn(Optional.of(room));
    }

}
