package com.hts.report.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.hts.report.dao.ReportDefinitionRepository;
import com.hts.report.domain.ReportDefinition;
import com.hts.report.mock.ReportDefinitionMockData;
import com.hts.report.service.impl.ReportDefinitionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportDefinitionServiceTest {

    private final int PAGE_NUMBER = 1;
    private final int PAGE_SIZE = 5;

    @Mock
    private ReportDefinitionRepository reportDefinitionReposiotryMock;

    @InjectMocks
    private ReportDefinitionService reportDefinitionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllDefinition() {
        when(reportDefinitionReposiotryMock.findAll(Mockito.any(Pageable.class)))
                .thenReturn(ReportDefinitionMockData.getReportDefinitionPagedData());

        PageRequest pageRequest = new PageRequest(PAGE_NUMBER, PAGE_SIZE);
        assertEquals("Test", reportDefinitionService.getAll(pageRequest).getContent().get(0).getName());
    }

    @Test
    public void testSave() {
        when(reportDefinitionReposiotryMock.save(Mockito.any(ReportDefinition.class)))
                .thenReturn(ReportDefinitionMockData.getReportDefinitionMockData());
        assertEquals("Test", reportDefinitionService.saveOrUpdate(ReportDefinitionMockData.getReportDefinitionMockData()).getName());
    }

    @Test
    public void tesGetDefinition() {
        when(reportDefinitionReposiotryMock.findOne(Mockito.any(Long.class)))
                .thenReturn(ReportDefinitionMockData.getReportDefinitionMockData());
        assertEquals("Test", reportDefinitionService.get(1L).getName());
    }

    @Test
    public void tesRemoveDefinition() {
        doNothing().when(reportDefinitionReposiotryMock).delete(Mockito.any(Long.class));
        reportDefinitionService.remove(1L);
    }
}
