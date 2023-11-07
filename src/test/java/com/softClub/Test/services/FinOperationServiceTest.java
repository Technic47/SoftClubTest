package com.softClub.Test.services;

import com.softClub.Test.exceptionhendlers.ResourceNotFoundException;
import com.softClub.Test.models.AbstractModelsTests;
import com.softClub.Test.models.FinOperation;
import com.softClub.Test.repositories.FinOperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FinOperationServiceTest extends AbstractModelsTests {
    private FinOperationRepository repository;
    private FinOperationService service;

    @BeforeEach
    void setUp() {
        repository = mock(FinOperationRepository.class);
        service = new FinOperationService(repository);
    }

    @Test
    void findInPeriod() {
        List<FinOperation> list = Arrays.asList(
                formFinOperation(),
                formFinOperation(),
                formFinOperation()
        );
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();

        doReturn(list)
                .when(repository)
                .findByDateTimeBetween(time1, time2);

        List<FinOperation> operations = service.findInPeriod(time1, time2);

        assertEquals(operations, list);
        verify(repository, times(1))
                .findByDateTimeBetween(any(LocalDateTime.class), any(LocalDateTime.class));
    }

    @Test
    void saveTest() {
        FinOperation operation = formFinOperation();

        doReturn(operation)
                .when(repository)
                .save(any(FinOperation.class));

        service.save(operation);

        verify(repository, times(1)).save(any(FinOperation.class));
    }

    @Test
    void getByIdTest() {
        FinOperation operation = formFinOperation();
        long id = operation.getId();

        doReturn(Optional.of(operation))
                .when(repository)
                .findById(id);

        FinOperation found = service.getById(id);

        assertEquals(found, operation);
        verify(repository, times(1)).findById(id);
    }

    @Test
    void getByIdTestError() {
        long id = 1L;

        doReturn(Optional.empty())
                .when(repository)
                .findById(id);

        assertThrows(ResourceNotFoundException.class, () -> service.getById(id));
        verify(repository, times(1)).findById(id);
    }

    @Test
    void deleteByIdTest() {
        long id = 1L;

        doReturn(true)
                .when(repository)
                .existsById(id);

        service.deleteById(id);

        verify(repository, times(1)).existsById(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void deleteByIdTestError() {
        long id = 1L;

        doReturn(false)
                .when(repository)
                .existsById(id);

        assertThrows(ResourceNotFoundException.class, () -> service.deleteById(id));
        verify(repository, times(1)).existsById(id);
        verifyNoMoreInteractions(repository);
    }
}