package hu.uni.djavorek.util;

import hu.uni.djavorek.model.ApplicationFilter;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FilterFactory {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static ApplicationFilter getApplicationFilter(@Nullable String applicationId, @Nullable String jobId, @Nullable String createdAfter, @Nullable String createdBefore, @Nullable String hasComment) {

        ApplicationFilter filter = new ApplicationFilter();

        try {
            if(applicationId != null && applicationId.length() > 0)
            {
                filter.setApplicationid(Long.valueOf(applicationId));
            }

            if(jobId != null && jobId.length() > 0)
            {
                filter.setJobId(Long.valueOf(jobId));
            }

            if(createdAfter != null && createdAfter.length() > 0)
            {
                Calendar createdAfterCalendar = Calendar.getInstance();
                createdAfterCalendar.setTime(dateFormat.parse(createdAfter));
                filter.setCreatedAfter(createdAfterCalendar);
            }

            if(createdBefore != null && createdBefore.length() > 0)
            {
                Calendar createdBeforeCalendar = Calendar.getInstance();
                createdBeforeCalendar.setTime(dateFormat.parse(createdBefore));
                filter.setCreatedBefore(createdBeforeCalendar);
            }

            if(hasComment != null && hasComment.length() > 0)
            {
                filter.setHasComment(Boolean.parseBoolean(hasComment));
            }
        } catch (NumberFormatException | ParseException formatException) {
            throw new IllegalArgumentException();
        }

        return filter;
    }
}
