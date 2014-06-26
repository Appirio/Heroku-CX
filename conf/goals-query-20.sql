SELECT
	q.max_goal_score__c,
	q.goal_type__c,
	q.goal_end_date__c,
	q.goal_name__c,
	q.is_goal__c,
	q.goal_start_date__c,
	q.max_score__c
FROM
	dd_assigned_goal__c ag
	INNER JOIN dms_question__c q ON ag.dd_survey_question__c = q.sfid  
WHERE
	(is_goal__c is not null and is_goal__c = true) and 
	ag.contact__c = ''{0}'' and
	(
		(
			q.goal_start_date__c <= ''{1}'' and q.goal_end_date__c >= ''{1}''
		) or (
			q.goal_start_date__c <= ''{2}'' and q.goal_end_date__c >= ''{2}''
		) 
	)