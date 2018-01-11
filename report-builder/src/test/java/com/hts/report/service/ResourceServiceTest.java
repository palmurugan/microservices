package com.hts.report.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.hts.report.dao.ResourceRepository;
import com.hts.report.domain.Resource;
import com.hts.report.mock.ResourceMockData;
import com.hts.report.service.impl.ResourceService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResourceServiceTest {

    private final int PAGE_NUMBER = 1;
    private final int PAGE_SIZE = 5;

    @Mock
    private ResourceRepository resourceRepositoryMock;

    @InjectMocks
    private ResourceService resourceService;

    @Test
    public void testGetAllResouce() {
        when(resourceRepositoryMock.findAll(Mockito.any(Pageable.class))).thenReturn(ResourceMockData.getResourcePagedMockData());

        PageRequest pageRequest = new PageRequest(PAGE_NUMBER, PAGE_SIZE);
        assertEquals("Test Display", resourceService.getAll(pageRequest).getContent().get(0).getDisplayName());
        assertEquals("Test View", resourceService.getAll(pageRequest).getContent().get(0).getSourceView());
    }

    @Test
    public void testSave() {
        when(resourceRepositoryMock.save(Mockito.any(Resource.class))).thenReturn(ResourceMockData.getResourceMockData());
        assertEquals("Test Display", resourceService.saveOrUpdate(ResourceMockData.getResourceMockData()).getDisplayName());
    }

    @Test
    public void tesGetResource() {
        when(resourceRepositoryMock.findOne(Mockito.any(Long.class))).thenReturn(ResourceMockData.getResourceMockData());
        assertEquals("Test Display", resourceService.get(1L).getDisplayName());
    }

    @Test
    public void tesGetResourceByStatus() {
        when(resourceRepositoryMock.findByStatus(Mockito.any(String.class))).thenReturn(ResourceMockData.getResourceListMockData());
        assertEquals("Test Display", resourceService.findByStatus("A").get(0).getDisplayName());
    }

    @Test
    public void tesRemoveResource() {
        doNothing().when(resourceRepositoryMock).delete(Mockito.any(Long.class));
        resourceService.remove(1L);
    }
}
