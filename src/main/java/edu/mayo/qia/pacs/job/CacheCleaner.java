package edu.mayo.qia.pacs.job;

import edu.mayo.qia.pacs.Notion;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Map;

public class CacheCleaner implements Job {
  public static void clean() {
    Notion.context.getBean("authorizationCache", Map.class).clear();
  }

    /**
     * Clean (remove) the specific user from authorizationCache bean.
     * @param user the name of user whose information should be removed from the cache bean.
     */
    public static void cleanUser(String user) {
        Notion.context.getBean("authorizationCache", Map.class).remove(user);
    }

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    clean();
  }
}
