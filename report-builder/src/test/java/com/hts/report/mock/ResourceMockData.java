package com.hts.report.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.hts.report.domain.Resource;

public class ResourceMockData {

    public static Resource getResourceMockData() {
        Resource resource = new Resource();
        resource.setResourceId(1L);
        resource.setDisplayName("Test Display");
        resource.setSourceView("Test View");
        resource.setStatus("A");
        return resource;
    }

    public static List<Resource> getResourceListMockData() {
        List<Resource> resourceList = new ArrayList<>();
        resourceList.add(getResourceMockData());
        return resourceList;
    }

    public static Page<Resource> getResourcePagedMockData() {
        Page<Resource> resourcePage = new PageImpl<Resource>(getResourceListMockData());
        return resourcePage;
    }
}
