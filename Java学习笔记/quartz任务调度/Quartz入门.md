## Quartz入门

#### 1. Quartz 作业

> Quartz作业定义要运行什么，即执行什么什么
>
> ```
> // Demo
> import org.quartz.Job;
> import org.quartz.JobExecutionContext;
> import org.quartz.JobExecutionException;
>  
> public class HelloJob implements Job
> {
> 	public void execute(JobExecutionContext context)
> 	throws JobExecutionException {
>  
> 		System.out.println("Hello Quartz!");	
>  
> 	}
> }
> ```

#### 2. Quartz触发器

> Quartz触发器定义Quartz作业的执行时间
>
> - SimpleTrigger – 允许设置开始时间，结束时间，重复间隔。
> - CronTrigger – 允许UNIX cron表达式来指定日期和时间来运行作业。
>
> ```
> // SimpleTrigger - 每5秒运行
> Trigger trigger = TriggerBuilder
> 	.newTrigger()
> 	.withIdentity("dummyTriggerName", "group1")
> 	.withSchedule(
> 	    SimpleScheduleBuilder.simpleSchedule()
> 		.withIntervalInSeconds(5).repeatForever())
> 	.build();
>
> // CronTrigger - 每5秒运行
> Trigger trigger = TriggerBuilder
> 	.newTrigger()
> 	.withIdentity("dummyTriggerName", "group1")
> 	.withSchedule(
> 		CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
> 	.build();
> ```

#### 3.Scheduler

> 调度类链接“工作”和“触发器”到一起，并执行它。
>
> ```
> Scheduler scheduler = new StdSchedulerFactory().getScheduler();
> scheduler.start();
> scheduler.scheduleJob(job, trigger);
> ```

#### 4.完整的例子

> ```
> // SimpleTrigger的例子 - 每间隔5秒运行。
> import org.quartz.JobBuilder;
> import org.quartz.JobDetail;
> import org.quartz.Scheduler;
> import org.quartz.SimpleScheduleBuilder;
> import org.quartz.Trigger;
> import org.quartz.TriggerBuilder;
> import org.quartz.impl.StdSchedulerFactory;
>  
> public class SimpleTriggerExample {
> 	public static void main(String[] args) throws Exception {
>  
> 		// Quartz 1.6.3
> 		// JobDetail job = new JobDetail();
> 		// job.setName("dummyJobName");
> 		// job.setJobClass(HelloJob.class);
>  
> 		JobDetail job = JobBuilder.newJob(HelloJob.class)
> 			.withIdentity("dummyJobName", "group1").build();
>  
>                 //Quartz 1.6.3
> 		// SimpleTrigger trigger = new SimpleTrigger();
> 		// trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
> 		// trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
> 		// trigger.setRepeatInterval(30000);
>  
> 		// Trigger the job to run on the next round minute
> 		Trigger trigger = TriggerBuilder
> 			.newTrigger()
> 			.withIdentity("dummyTriggerName", "group1")
> 			.withSchedule(
> 				SimpleScheduleBuilder.simpleSchedule()
> 					.withIntervalInSeconds(5).repeatForever())
> 			.build();
>  
> 		// schedule it
> 		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
> 		scheduler.start();
> 		scheduler.scheduleJob(job, trigger);
>  
> 	}
> }
>
>
> // CronTrigger例子 - 在每5秒运行作业。
> import org.quartz.CronScheduleBuilder;
> import org.quartz.JobBuilder;
> import org.quartz.JobDetail;
> import org.quartz.Scheduler;
> import org.quartz.Trigger;
> import org.quartz.TriggerBuilder;
> import org.quartz.impl.StdSchedulerFactory;
>  
> public class CronTriggerExample 
> {
>     public static void main( String[] args ) throws Exception
>     {
>     	//Quartz 1.6.3
>     	//JobDetail job = new JobDetail();
>     	//job.setName("dummyJobName");
>     	//job.setJobClass(HelloJob.class);    	
>     	JobDetail job = JobBuilder.newJob(HelloJob.class)
> 		.withIdentity("dummyJobName", "group1").build();
>  
> 	//Quartz 1.6.3
>     	//CronTrigger trigger = new CronTrigger();
>     	//trigger.setName("dummyTriggerName");
>     	//trigger.setCronExpression("0/5 * * * * ?");
>  
>     	Trigger trigger = TriggerBuilder
> 		.newTrigger()
> 		.withIdentity("dummyTriggerName", "group1")
> 		.withSchedule(
> 			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
> 		.build();
>  
>     	//schedule it
>     	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
>     	scheduler.start();
>     	scheduler.scheduleJob(job, trigger);
>  
>     }
> }
> ```



**以上参考：http://www.yiibai.com/quartz/quartz-helloworld.html**