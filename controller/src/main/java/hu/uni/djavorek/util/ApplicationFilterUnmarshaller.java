package hu.uni.djavorek.util;

import hu.uni.djavorek.model.ApplicationFilter;

public class ApplicationFilterUnmarshaller {
    public static ApplicationFilter unmarshal(hu.uni.djavorek.dto.ApplicationFilter requestEntityFilter) {
        ApplicationFilter filter = new ApplicationFilter();

        filter.setApplicationid(Long.valueOf(requestEntityFilter.getApplicationId()));
        filter.setJobId(Long.valueOf(requestEntityFilter.getJobId()));
        filter.setCreatedAfter(CalendarConverter.unmarshal(requestEntityFilter.getCreatedAfter()));
        filter.setCreatedBefore(CalendarConverter.unmarshal(requestEntityFilter.getCreatedBefore()));
        filter.setHasComment(requestEntityFilter.isHasComment());

        return filter;
    }
}
