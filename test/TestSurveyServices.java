import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.appirio.diageo.db.DiageoServicesException;
import com.appirio.diageo.db.manager.AccountDBManager;
import com.appirio.diageo.db.manager.SurveyDBManager;
import com.appirio.diageo.db.manager.api12.SurveyDBManager12;
import com.appirio.diageo.db.manager.api13.SurveyDBManager13;
import com.appirio.diageo.db.manager.api14.SurveyDBManager14;
import com.appirio.diageo.db.manager.api15.SurveyDBManager15;
import com.appirio.diageo.db.manager.api17.SurveyDBManager17;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class TestSurveyServices {

	private TestDBManager testDBManager;
	
	
	@Before
	public void setup() {
		try {
			testDBManager = new TestDBManager();
			
			// delete data
			testDBManager.clearDB();
			testDBManager.populateTestSurveys();
			
			// create test data
		} catch (DiageoServicesException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@After
	public void tearDown() {
		try {
			// delete data
			testDBManager.clearDB();
			
			testDBManager.close();
		} catch (DiageoServicesException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public boolean isAlphabeticalOrder(JsonNode surveys) {
		String currentSurveyName = null;
		
		for(JsonNode survey : surveys) {
			if(currentSurveyName == null) {
				currentSurveyName = survey.get("name").asText();
			}
			
			if(currentSurveyName.compareToIgnoreCase(survey.get("name").asText()) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	@Test
	public void testGetSurveysByAccountId() {
		try {
			SurveyDBManager manager = new SurveyDBManager();
			
			JsonNode result = manager.getSurveys("1");
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testGetSurveysByAccountObject() {
		try {
			SurveyDBManager manager = new SurveyDBManager();
			AccountDBManager accountManager = new AccountDBManager();
			
			ObjectNode account = accountManager.getAccount("1");
			
			JsonNode result = manager.getSurveys(account);
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
			accountManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetSurveys() {
		try {
			SurveyDBManager manager = new SurveyDBManager();
			
			JsonNode result = manager.getSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(4, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testGetUniversalSurveys12() {
		try {
			SurveyDBManager12 manager = new SurveyDBManager12();
			
			JsonNode result = manager.getUniversalSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testGetUniversalSurveys13() {
		try {
			SurveyDBManager13 manager = new SurveyDBManager13();
			
			JsonNode result = manager.getUniversalSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetSurveysByAccountObject13() {
		try {
			SurveyDBManager13 manager = new SurveyDBManager13();
			AccountDBManager accountManager = new AccountDBManager();
			
			ObjectNode account = accountManager.getAccount("1");
			
			JsonNode result = manager.getSurveys(account);
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
			accountManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetUniversalSurveys14() {
		try {
			SurveyDBManager14 manager = new SurveyDBManager14();
			
			JsonNode result = manager.getUniversalSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetSurveysByAccountObject14() {
		try {
			SurveyDBManager14 manager = new SurveyDBManager14();
			AccountDBManager accountManager = new AccountDBManager();
			
			ObjectNode account = accountManager.getAccount("1");
			
			JsonNode result = manager.getSurveys(account);
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(2, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
			accountManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testGetUniversalSurveys15() {
		try {
			SurveyDBManager15 manager = new SurveyDBManager15();
			
			JsonNode result = manager.getUniversalSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(4, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetSurveysByAccountObject15() {
		try {
			SurveyDBManager15 manager = new SurveyDBManager15();
			AccountDBManager accountManager = new AccountDBManager();
			
			ObjectNode account = accountManager.getAccount("1");
			
			JsonNode result = manager.getSurveys(account);
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(4, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			manager.close();
			accountManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testGetUniversalSurveys17() {
		try {
			SurveyDBManager17 manager = new SurveyDBManager17();
			
			JsonNode result = manager.getUniversalSurveys();
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(5, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			int parentSurveyCount = 0;
			for(JsonNode survey : result) {
				if(survey.get("name").asText().equals("parent survey")) {
					parentSurveyCount++;
					Assert.assertTrue(survey.has("childSurveys"));
					
					Assert.assertEquals("child survey 1", ((ArrayNode)survey.get("childSurveys")).get(0).get("name").asText());
					Assert.assertEquals("child survey 2", ((ArrayNode)survey.get("childSurveys")).get(1).get("name").asText());
				}
			}
			
			Assert.assertEquals(1, parentSurveyCount);

			manager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}
	
	@Test
	public void testGetSurveysByAccountObject17() {
		try {
			SurveyDBManager17 manager = new SurveyDBManager17();
			AccountDBManager accountManager = new AccountDBManager();
			
			ObjectNode account = accountManager.getAccount("1");
			
			JsonNode result = manager.getSurveys(account);
			
			Assert.assertTrue(result.isArray());
			Assert.assertEquals(5, result.size());
			Assert.assertTrue(isAlphabeticalOrder(result));
			
			int parentSurveyCount = 0;
			for(JsonNode survey : result) {
				if(survey.get("name").asText().equals("parent survey")) {
					parentSurveyCount++;
					Assert.assertTrue(survey.has("childSurveys"));
					
					Assert.assertEquals("child survey 1", ((ArrayNode)survey.get("childSurveys")).get(0).get("name").asText());
					Assert.assertEquals("child survey 2", ((ArrayNode)survey.get("childSurveys")).get(1).get("name").asText());
				}
			}
			
			Assert.assertEquals(1, parentSurveyCount);

			manager.close();
			accountManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

	// TODO: finish testing other survey manager methods
	@Test
	public void testCreateMultiProductSurvey17() {
		try {
			String externalId = UUID.randomUUID().toString();
			JsonNode body = new ObjectMapper().readTree("[{\"isparent__c\":\"f\",\"parent_survey__c\":null,\"enable_edit_on_review_screen__c\":\"f\",\"name\":\"dd3qa - SELECT\",\"sfid\":\"a2cK0000000OkQgIAK\",\"survey_type__c\":\"Product\",\"first_question__c\":\"a2dK00000000JmLIAU\",\"grading_scale__c\":null,\"total_possible_score__c\":null,\"questions\":[{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000JmHIAU\",\"label_for_add_l_comments__c\":\"Comments\",\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\" NO\",\"checked\":false}],\"sfid\":\"a2dK00000000JmLIAU\",\"question_text__c\":\"Do you like the select UI?\",\"parent_question__c\":null,\"name\":\"Q-0083\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OkQgIAK\",\"original_answer_options__c\":\"YES, NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":\"Comments\",\"answer_options__c\":[{\"text\":\"Tony likes it\",\"checked\":true},{\"text\":\" Tom likes it\",\"checked\":true},{\"text\":\" Brandon likes it\",\"checked\":true},{\"text\":\" Igor likes it\",\"checked\":false}],\"sfid\":\"a2dK00000000JmHIAU\",\"question_text__c\":\"What do you think about the multi-select UI?\",\"parent_question__c\":null,\"name\":\"Q-0084\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OkQgIAK\",\"original_answer_options__c\":\"Tony likes it, Tom likes it, Brandon likes it, Igor likes it\",\"answer_text__c\":\"Tony likes it; Tom likes it; Brandon likes it\",\"answer_value__c\":null}],\"count\":2,\"display\":\"t\",\"location\":{\"tdlinx_outlet_city__c\":\"Huntington Beach\",\"tdlinx_outlet_zip_code__c\":\"926468331\",\"tdlinx_outlet_state__c\":\"CA\",\"tdlinx_outlet_addr__c\":\"22111 Luau Ln\",\"billingstate\":\"CA\",\"billingcountry\":null,\"billingpostalcode\":\"926468331\",\"billingcity\":\"Huntington Beach\",\"billingstreet\":\"22111 Luau Ln\",\"sfid\":\"001K000000pW7oaIAC\",\"tdlinx_outlet_desc__c\":\"Diageo\",\"name\":\"Diageo test very long name on Account when text wrapper\",\"distance\":379.60952550137864},\"contact__c\":\"003K000000hWUvGIAW\",\"account__c\":\"001K000000pW7oaIAC\",\"survey_id\":0,\"upc__c\":\"1234\",\"manually_entered_upc_description__c\":\"1234\",\"manually_entered_brand_desc__c\":\"1234\",\"manually_entered_base_size__c\":\"0.05L\",\"note__c\":\"test\"},{\"isparent__c\":\"f\",\"parent_survey__c\":null,\"enable_edit_on_review_screen__c\":\"f\",\"name\":\"dd3qa - SELECT\",\"sfid\":\"a2cK0000000OkQgIAK\",\"survey_type__c\":\"Product\",\"first_question__c\":\"a2dK00000000JmLIAU\",\"grading_scale__c\":null,\"total_possible_score__c\":null,\"questions\":[{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000JmHIAU\",\"label_for_add_l_comments__c\":\"Comments\",\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\" NO\",\"checked\":false}],\"sfid\":\"a2dK00000000JmLIAU\",\"question_text__c\":\"Do you like the select UI?\",\"parent_question__c\":null,\"name\":\"Q-0083\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OkQgIAK\",\"original_answer_options__c\":\"YES, NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":\"Comments\",\"answer_options__c\":[{\"text\":\"Tony likes it\",\"checked\":false},{\"text\":\" Tom likes it\",\"checked\":false},{\"text\":\" Brandon likes it\",\"checked\":true},{\"text\":\" Igor likes it\",\"checked\":false}],\"sfid\":\"a2dK00000000JmHIAU\",\"question_text__c\":\"What do you think about the multi-select UI?\",\"parent_question__c\":null,\"name\":\"Q-0084\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OkQgIAK\",\"original_answer_options__c\":\"Tony likes it, Tom likes it, Brandon likes it, Igor likes it\",\"answer_text__c\":\" Brandon likes it\",\"answer_value__c\":null}],\"count\":2,\"display\":\"t\",\"location\":{\"tdlinx_outlet_city__c\":\"Huntington Beach\",\"tdlinx_outlet_zip_code__c\":\"926468331\",\"tdlinx_outlet_state__c\":\"CA\",\"tdlinx_outlet_addr__c\":\"22111 Luau Ln\",\"billingstate\":\"CA\",\"billingcountry\":null,\"billingpostalcode\":\"926468331\",\"billingcity\":\"Huntington Beach\",\"billingstreet\":\"22111 Luau Ln\",\"sfid\":\"001K000000pW7oaIAC\",\"tdlinx_outlet_desc__c\":\"Diageo\",\"name\":\"Diageo test very long name on Account when text wrapper\",\"distance\":379.60952550137864},\"contact__c\":\"003K000000hWUvGIAW\",\"account__c\":\"001K000000pW7oaIAC\",\"survey_id\":1,\"upc__c\":\"1234\",\"manually_entered_upc_description__c\":\"1234\",\"manually_entered_brand_desc__c\":\"1234\",\"manually_entered_base_size__c\":\"0.07L\",\"note__c\":\"test\"}]");
			
			SurveyDBManager manager = new SurveyDBManager();
			manager.createSurvey15(body, externalId);
			
			ArrayNode submissions = manager.getSurveySubmissions(externalId);
			
			Assert.assertEquals(1, submissions.size());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	// TODO: finish testing other survey manager methods
	@Test
	public void testCreateScoredSurvey17() {
		try {
			String externalId = UUID.randomUUID().toString();
			JsonNode body = new ObjectMapper().readTree("[{\"isparent__c\":\"f\",\"parent_survey__c\":null,\"enable_edit_on_review_screen__c\":\"f\",\"name\":\"5 min survey\",\"sfid\":\"a2cK0000000OpxtIAC\",\"survey_type__c\":\"Non Product\",\"first_question__c\":\"a2dK00000000Q8gIAE\",\"grading_scale__c\":\"a2lK00000000JvkIAE\",\"total_possible_score__c\":\"90\",\"questions\":[{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q9FIAU\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000Q8gIAE\",\"question_text__c\":\"Is Smirnoff in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0272\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000Q8qIAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"No. 21\",\"checked\":false},{\"text\":\"Raspberry\",\"checked\":false},{\"text\":\"Citrus\",\"checked\":false},{\"text\":\"Watermelon\",\"checked\":false},{\"text\":\"Green Apple\",\"checked\":false},{\"text\":\"Whipped Cream\",\"checked\":false},{\"text\":\"Peach\",\"checked\":false},{\"text\":\"Cherry\",\"checked\":false},{\"text\":\"Vanilla\",\"checked\":false},{\"text\":\"Kissed Caramel\",\"checked\":true},{\"text\":\"Raspberry Sorbet Light\",\"checked\":false},{\"text\":\"Pineapple Coconut Sorbet\",\"checked\":false},{\"text\":\"Strawberry\",\"checked\":false},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000Q8lIAE\",\"question_text__c\":\"Which of the following varients are in distribution?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0273\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"No. 21\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Raspberry\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Citrus\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Watermelon\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Green Apple\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Whipped Cream\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Peach\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Cherry\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Vanilla\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Kissed Caramel\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Raspberry Sorbet Light\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Pineapple Coconut Sorbet\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Strawberry\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"No. 21,Raspberry,Citrus,Watermelon,Green Apple,Whipped Cream,Peach,Cherry,Vanilla,Kissed Caramel,Raspberry Sorbet Light,Pineapple Coconut Sorbet,Strawberry\",\"answer_text__c\":\"Kissed Caramel\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q8vIAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000Q8qIAE\",\"question_text__c\":\"What are the total number of facings for No.21?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0274\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"25\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q90IAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000Q8vIAE\",\"question_text__c\":\"Are the No. 21 facings equal to or greater then Svedka facings?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0275\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q95IAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000Q90IAE\",\"question_text__c\":\"What are the total number of Smirnoff Flavor Facings?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0276\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"7\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q9AIAU\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000Q95IAE\",\"question_text__c\":\"Are the total Smirnoff Flavor facings  equal to or greater then the total Pinnacle facings?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0277\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000Q9AIAU\",\"question_text__c\":\"Is there signage on the shelf?\",\"parent_question__c\":\"a2dK00000000Q8gIAE\",\"name\":\"Q-0278\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q9eIAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000Q9FIAU\",\"question_text__c\":\"Is Ketel One in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0279\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000Q9PIAU\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Ketel One Base\",\"checked\":false},{\"text\":\"Citroen\",\"checked\":false},{\"text\":\"Oranje \",\"checked\":true},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000Q9KIAU\",\"question_text__c\":\"Which of the following varients are in distribution?\",\"parent_question__c\":\"a2dK00000000Q9FIAU\",\"name\":\"Q-0280\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Ketel One Base\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Citroen\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Oranje \\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"Ketel One Base,Citroen,Oranje \",\"answer_text__c\":\"Oranje \",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q9UIAU\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000Q9PIAU\",\"question_text__c\":\"What are the total Number of Ketel One facings?\",\"parent_question__c\":\"a2dK00000000Q9FIAU\",\"name\":\"Q-0281\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"4\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000Q9UIAU\",\"question_text__c\":\"Are the total Ketel One facings equal to or greater then total Absolut facings?\",\"parent_question__c\":\"a2dK00000000Q9FIAU\",\"name\":\"Q-0282\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QA3IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000Q9eIAE\",\"question_text__c\":\"Is Ciroc in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0283\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QAIIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QA3IAM\",\"question_text__c\":\"Is Captain Morgan in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0288\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QB6IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QAIIA2\",\"question_text__c\":\"Is Crown Royal in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0292\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000QASIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"De Luxe\",\"checked\":true},{\"text\":\"Maple Finished\",\"checked\":false},{\"text\":\"Black\",\"checked\":false},{\"text\":\"XO\",\"checked\":false},{\"text\":\"Reserve\",\"checked\":false},{\"text\":\"XR\",\"checked\":false},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000QANIA2\",\"question_text__c\":\"Which of the following varients are in distribution?\",\"parent_question__c\":\"a2dK00000000QAIIA2\",\"name\":\"Q-0293\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"De Luxe\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Maple Finished\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Black\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"XO\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Reserve\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"XR\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"De Luxe,Maple Finished,Black,XO,Reserve,XR\",\"answer_text__c\":\"De Luxe\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QAXIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QASIA2\",\"question_text__c\":\"What are the total number of Crown Royal facings?\",\"parent_question__c\":\"a2dK00000000QAIIA2\",\"name\":\"Q-0294\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"3\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QAcIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QAXIA2\",\"question_text__c\":\"Are the Crown Royal purple facings equal to or greater than total Jack Daniels Black facings?\",\"parent_question__c\":\"a2dK00000000QAIIA2\",\"name\":\"Q-0295\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QAcIAM\",\"question_text__c\":\"Is there signage on the shelf?\",\"parent_question__c\":\"a2dK00000000QAIIA2\",\"name\":\"Q-0296\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QBkIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QB6IAM\",\"question_text__c\":\"Is Baileys in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0302\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000QBBIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Original \",\"checked\":false},{\"text\":\"Vanilla Cinnamon\",\"checked\":false},{\"text\":\"Hazelnut\",\"checked\":false},{\"text\":\"Caramel\",\"checked\":true},{\"text\":\"Coffee\",\"checked\":false},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000Q9cIAE\",\"question_text__c\":\"Which of the following varients are in distribution?\",\"parent_question__c\":\"a2dK00000000QB6IAM\",\"name\":\"Q-0303\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Original \\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Vanilla Cinnamon\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Hazelnut\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Caramel\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Coffee\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"Original ,Vanilla Cinnamon,Hazelnut,Caramel,Coffee\",\"answer_text__c\":\"Caramel\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QBGIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QBBIA2\",\"question_text__c\":\"What are the total number of Baileys facings?\",\"parent_question__c\":\"a2dK00000000QB6IAM\",\"name\":\"Q-0304\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"3\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QBLIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QBGIA2\",\"question_text__c\":\"Are the total Baileys facings equal to or greater then the total Kahlua facings?\",\"parent_question__c\":\"a2dK00000000QB6IAM\",\"name\":\"Q-0305\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QBLIA2\",\"question_text__c\":\"Is there signage on the shelf?\",\"parent_question__c\":\"a2dK00000000QB6IAM\",\"name\":\"Q-0306\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QBvIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QBkIAM\",\"question_text__c\":\"Is Johnnie Walker in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0312\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000QBuIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Red Label\",\"checked\":true},{\"text\":\"Black Label\",\"checked\":false},{\"text\":\"Double Black Label\",\"checked\":false},{\"text\":\"Gold Label Reserve\",\"checked\":false},{\"text\":\"Platinum Label\",\"checked\":false},{\"text\":\"Blue Label\",\"checked\":true},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000QBpIAM\",\"question_text__c\":\"Which of the follow varients are in distribution?\",\"parent_question__c\":\"a2dK00000000QBkIAM\",\"name\":\"Q-0313\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Red Label\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Black Label\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Double Black Label\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Gold Label Reserve\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Platinum Label\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Blue Label\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"Red Label,Black Label,Double Black Label,Gold Label Reserve,Platinum Label,Blue Label\",\"answer_text__c\":\"Red Label;Blue Label\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QBzIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QBuIAM\",\"question_text__c\":\"What are the total number of Johnnie Walker facings?\",\"parent_question__c\":\"a2dK00000000QBkIAM\",\"name\":\"Q-0314\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"5\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000RhTIAU\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QBzIAM\",\"question_text__c\":\"Are the total Johnnie Walker Red Label facings equal to or greater then the total Dewers facings?\",\"parent_question__c\":\"a2dK00000000QBkIAM\",\"name\":\"Q-0315\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QAYIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Yes\",\"checked\":false},{\"text\":\"No\",\"checked\":true}],\"sfid\":\"a2dK00000000RhTIAU\",\"question_text__c\":\"Are the total Johnnie Walker Black Label facings equal to or greater then the total Chivas Regal facings?\",\"parent_question__c\":\"a2dK00000000QBkIAM\",\"name\":\"Q-0361\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":\"No\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QAYIA2\",\"question_text__c\":\"Is there signage on the shelf?\",\"parent_question__c\":\"a2dK00000000QBkIAM\",\"name\":\"Q-0316\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCdIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QBvIAM\",\"question_text__c\":\"Is Bulleit Bourbon in Distribution?\",\"parent_question__c\":null,\"name\":\"Q-0317\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":\"YES\",\"next_question__c\":\"a2dK00000000QCEIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Bourbon\",\"checked\":false},{\"text\":\"Rye\",\"checked\":true},{\"text\":\"10 Yr\",\"checked\":false},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000QC4IAM\",\"question_text__c\":\"Which of the follow varients are in distribution?\",\"parent_question__c\":\"a2dK00000000QBvIAM\",\"name\":\"Q-0318\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Bourbon\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Rye\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"10 Yr\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"Bourbon,Rye,10 Yr\",\"answer_text__c\":\"Rye\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCOIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QCEIA2\",\"question_text__c\":\"What are the total number of Bulleit facings?\",\"parent_question__c\":\"a2dK00000000QBvIAM\",\"name\":\"Q-0319\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"6\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000Q9dIAE\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QCOIA2\",\"question_text__c\":\"Are the total Bulleit facings equal to or greater then the total Makers Mark facings?\",\"parent_question__c\":\"a2dK00000000QBvIAM\",\"name\":\"Q-0320\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000Q9dIAE\",\"question_text__c\":\"Is there signage on the shelf?\",\"parent_question__c\":\"a2dK00000000QBvIAM\",\"name\":\"Q-0321\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCiIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QCdIAM\",\"question_text__c\":\"Now please describe the displays on the account floor.  What are the total number of Smirnoff cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0327\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"12\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCnIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QCiIAM\",\"question_text__c\":\"Are the total Smirnoff cases equal to or greater than Svedka?\",\"parent_question__c\":null,\"name\":\"Q-0328\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCsIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QCnIAM\",\"question_text__c\":\"Is there Smirnoff signage?\",\"parent_question__c\":null,\"name\":\"Q-0329\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCxIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QCsIAM\",\"question_text__c\":\"What are the total number of Ketel One cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0330\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"4\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QD2IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QCxIAM\",\"question_text__c\":\"Are the total Ketel One cases equal to or greater than Absolut cases?\",\"parent_question__c\":null,\"name\":\"Q-0331\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QD7IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QD2IAM\",\"question_text__c\":\"Is there Ketel One signage?\",\"parent_question__c\":null,\"name\":\"Q-0332\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDCIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QD7IAM\",\"question_text__c\":\"What are the total number of Ciroc cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0333\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"3\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QCoIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QDCIA2\",\"question_text__c\":\"Are the total Ciroc cases equal to or greater than Grey Goose cases?\",\"parent_question__c\":null,\"name\":\"Q-0334\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDHIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QCoIAM\",\"question_text__c\":\"Is there Ciroc signage?\",\"parent_question__c\":null,\"name\":\"Q-0335\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDMIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QDHIA2\",\"question_text__c\":\"What are the total number of Captain Morgan cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0336\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"12\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDRIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QDMIA2\",\"question_text__c\":\"Are the total Captain Morgan cases equal to or greater than Bacardi cases?\",\"parent_question__c\":null,\"name\":\"Q-0337\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDWIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QDRIA2\",\"question_text__c\":\"Is there Captain Morgan signage?\",\"parent_question__c\":null,\"name\":\"Q-0338\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDbIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QDWIA2\",\"question_text__c\":\"What are the total number of Crown Royal cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0339\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"54\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDgIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QDbIAM\",\"question_text__c\":\"Are the total Crown Royal cases equal to or greater than Jack Daniels cases?\",\"parent_question__c\":null,\"name\":\"Q-0340\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDlIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QDgIAM\",\"question_text__c\":\"Is there Crown Royal signage?\",\"parent_question__c\":null,\"name\":\"Q-0341\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDvIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QDlIAM\",\"question_text__c\":\"What are the total number of Baileys cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0345\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"8\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QDqIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QDvIAM\",\"question_text__c\":\"Are the total Baileys cases equal to or greater than Kahlua cases?\",\"parent_question__c\":null,\"name\":\"Q-0347\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QE5IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QDqIAM\",\"question_text__c\":\"Is there Baileys signage?\",\"parent_question__c\":null,\"name\":\"Q-0346\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QEAIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QE5IAM\",\"question_text__c\":\"What are the total number of Johnnie Walker cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0351\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"12\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QEFIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QEAIA2\",\"question_text__c\":\"Are the total Johnnie Walker Black cases equal to or greater than Chivas Regal cases?\",\"parent_question__c\":null,\"name\":\"Q-0352\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QD3IAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QEFIA2\",\"question_text__c\":\"Is there Johnnie Walker signage?\",\"parent_question__c\":null,\"name\":\"Q-0353\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QEPIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[\"Yes\",\"No\"],\"sfid\":\"a2dK00000000QD3IAM\",\"question_text__c\":\"What are the total number of Bulleit cases on the floor?\",\"parent_question__c\":null,\"name\":\"Q-0354\",\"question_type__c\":\"Count\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"Yes,No\",\"answer_text__c\":null,\"answer_value__c\":\"12\"},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QEKIA2\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":false},{\"text\":\"NO\",\"checked\":true}],\"sfid\":\"a2dK00000000QEPIA2\",\"question_text__c\":\"Are the total Bulleit cases equal to or greater than Maker's Mark cases?\",\"parent_question__c\":null,\"name\":\"Q-0356\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"NO\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK00000000QEjIAM\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"YES\",\"checked\":true},{\"text\":\"NO\",\"checked\":false}],\"sfid\":\"a2dK00000000QEKIA2\",\"question_text__c\":\"Is there Bulleit signage?\",\"parent_question__c\":null,\"name\":\"Q-0355\",\"question_type__c\":\"Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"YES\\\", \\\"score\\\":\\\"1\\\"}, {\\\"value\\\":\\\"NO\\\", \\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"YES,NO\",\"answer_text__c\":\"YES\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"t\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Smirnoff\",\"checked\":false},{\"text\":\"Ketel One\",\"checked\":false},{\"text\":\"Ciroc\",\"checked\":false},{\"text\":\"Captain Morgan\",\"checked\":true},{\"text\":\"Crown Royal\",\"checked\":true},{\"text\":\"Don Julio\",\"checked\":false},{\"text\":\"Baileys\",\"checked\":true},{\"text\":\"Tanqueray\",\"checked\":true},{\"text\":\"Johnnie Walker\",\"checked\":false},{\"text\":\"Bulleit\",\"checked\":false},{\"text\":\"Bushmills\",\"checked\":true},{\"text\":\"None of the Above\",\"checked\":false}],\"sfid\":\"a2dK00000000QEjIAM\",\"question_text__c\":\"Which of the following brands have counter units or signage?\",\"parent_question__c\":null,\"name\":\"Q-0360\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000OpxtIAC\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Smirnoff\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Ketel One\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Ciroc\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Captain Morgan\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Crown Royal\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Don Julio\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Baileys\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Tanqueray\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Johnnie Walker\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Bulleit\\\", \\\"score\\\":\\\"1\\\"},{\\\"value\\\":\\\"Bushmills\\\", \\\"score\\\":\\\"1\\\"}]\",\"delimitedAnswerOptions\":\"Smirnoff,Ketel One,Ciroc,Captain Morgan,Crown Royal,Don Julio,Baileys,Tanqueray,Johnnie Walker,Bulleit,Bushmills\",\"answer_text__c\":\"Captain Morgan;Crown Royal;Baileys;Tanqueray;Bushmills\",\"answer_value__c\":null}],\"count\":66,\"display\":\"t\",\"location\":{\"tdlinx_outlet_city__c\":\"Huntington Beach\",\"tdlinx_outlet_zip_code__c\":\"926468331\",\"tdlinx_outlet_state__c\":\"CA\",\"tdlinx_outlet_addr__c\":\"22111 Luau Ln\",\"billingstate\":\"CA\",\"billingcountry\":null,\"billingpostalcode\":\"926468331\",\"billingcity\":\"Huntington Beach\",\"billingstreet\":\"22111 Luau Ln\",\"sfid\":\"001K000000pW7oaIAC\",\"tdlinx_outlet_desc__c\":\"Diageo\",\"name\":\"Diageo test very long name on Account when text wrapper\",\"distance\":379.60952550137864},\"contact__c\":\"003K000000hWUvGIAW\",\"account__c\":\"001K000000pW7oaIAC\",\"survey_id\":0}]");
			
			SurveyDBManager manager = new SurveyDBManager();
			manager.createSurvey15(body, externalId);
			
			ArrayNode submissions = manager.getSurveySubmissions(externalId);
			
			Assert.assertEquals(1, submissions.size());
			
			ObjectNode submission = (ObjectNode) submissions.get(0);
			
			Assert.assertEquals(32, submission.get("score__c").asInt());
			Assert.assertEquals(29, submission.get("total_actual_score__c").asInt());
			Assert.assertEquals(externalId, submission.get("external_id__c").asText());
			Assert.assertEquals(90, submission.get("total_possible_score__c").asInt());
			Assert.assertEquals("seriously?", submission.get("grade__c").asText());
			Assert.assertEquals("003K000000hWUvGIAW", submission.get("contact__c").asText());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	// TODO: finish testing other survey manager methods
	@Test
	public void testCreateMultiProductScoredSurvey17() {
		try {
			String externalId = UUID.randomUUID().toString();
			JsonNode body = new ObjectMapper().readTree("[{\"isparent__c\":\"f\",\"parent_survey__c\":null,\"enable_edit_on_review_screen__c\":\"t\",\"name\":\"Test MD\",\"sfid\":\"a2cK0000000wXuIIAU\",\"survey_type__c\":\"Product\",\"first_question__c\":\"a2dK0000000FDPfIAO\",\"grading_scale__c\":\"a2lK00000000JvVIAU\",\"total_possible_score__c\":\"35\",\"questions\":[{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK0000000FDPkIAO\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Test 1\",\"checked\":true},{\"text\":\"Test 2\",\"checked\":false},{\"text\":\"Test 3\",\"checked\":true}],\"sfid\":\"a2dK0000000FDPfIAO\",\"question_text__c\":\"Test 1\",\"parent_question__c\":null,\"name\":\"Q-0451\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000wXuIIAU\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Test 1\\\",\\\"score\\\":\\\"10\\\"},{\\\"value\\\":\\\"Test 2\\\",\\\"score\\\":\\\"10\\\"},{\\\"value\\\":\\\"Test 3\\\",\\\"score\\\":\\\"10\\\"}]\",\"delimitedAnswerOptions\":\"Test 1,Test 2,Test 3\",\"answer_text__c\":\"Test 1;Test 3\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Yes\",\"checked\":false},{\"text\":\"No\",\"checked\":true}],\"sfid\":\"a2dK0000000FDPkIAO\",\"question_text__c\":\"Test 2\",\"parent_question__c\":null,\"name\":\"Q-0452\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000wXuIIAU\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Yes\\\",\\\"score\\\":\\\"5\\\"},{\\\"value\\\":\\\"No\\\",\\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"Yes,No\",\"answer_text__c\":\"No\",\"answer_value__c\":null}],\"count\":2,\"display\":\"t\",\"location\":{\"tdlinx_outlet_city__c\":\"Huntington Beach\",\"tdlinx_outlet_zip_code__c\":\"926468331\",\"tdlinx_outlet_state__c\":\"CA\",\"tdlinx_outlet_addr__c\":\"22111 Luau Ln\",\"billingstate\":\"CA\",\"billingcountry\":null,\"billingpostalcode\":\"926468331\",\"billingcity\":\"Huntington Beach\",\"billingstreet\":\"22111 Luau Ln\",\"sfid\":\"001K000000pW7oaIAC\",\"tdlinx_outlet_desc__c\":\"Diageo\",\"name\":\"Diageo test very long name on Account when text wrapper\",\"distance\":379.60952550137864},\"contact__c\":\"003K000000hWUvGIAW\",\"account__c\":\"001K000000pW7oaIAC\",\"survey_id\":0,\"upc__c\":\"12345\",\"manually_entered_upc_description__c\":\"asfasdf\",\"manually_entered_brand_desc__c\":\"asdf\",\"manually_entered_base_size__c\":\"0.05L\"},{\"isparent__c\":\"f\",\"parent_survey__c\":null,\"enable_edit_on_review_screen__c\":\"t\",\"name\":\"Test MD\",\"sfid\":\"a2cK0000000wXuIIAU\",\"survey_type__c\":\"Product\",\"first_question__c\":\"a2dK0000000FDPfIAO\",\"grading_scale__c\":\"a2lK00000000JvVIAU\",\"total_possible_score__c\":\"35\",\"questions\":[{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":\"a2dK0000000FDPkIAO\",\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Test 1\",\"checked\":true},{\"text\":\"Test 2\",\"checked\":true},{\"text\":\"Test 3\",\"checked\":true}],\"sfid\":\"a2dK0000000FDPfIAO\",\"question_text__c\":\"Test 1\",\"parent_question__c\":null,\"name\":\"Q-0451\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000wXuIIAU\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Test 1\\\",\\\"score\\\":\\\"10\\\"},{\\\"value\\\":\\\"Test 2\\\",\\\"score\\\":\\\"10\\\"},{\\\"value\\\":\\\"Test 3\\\",\\\"score\\\":\\\"10\\\"}]\",\"delimitedAnswerOptions\":\"Test 1,Test 2,Test 3\",\"answer_text__c\":\"Test 1;Test 2;Test 3\",\"answer_value__c\":null},{\"include_none_of_the_above__c\":\"f\",\"conditional_answer__c\":null,\"next_question__c\":null,\"label_for_add_l_comments__c\":null,\"answer_options__c\":[{\"text\":\"Yes\",\"checked\":false},{\"text\":\"No\",\"checked\":true}],\"sfid\":\"a2dK0000000FDPkIAO\",\"question_text__c\":\"Test 2\",\"parent_question__c\":null,\"name\":\"Q-0452\",\"question_type__c\":\"Multi-Select\",\"dms_survey__c\":\"a2cK0000000wXuIIAU\",\"original_answer_options__c\":\"[{\\\"value\\\":\\\"Yes\\\",\\\"score\\\":\\\"5\\\"},{\\\"value\\\":\\\"No\\\",\\\"score\\\":\\\"0\\\"}]\",\"delimitedAnswerOptions\":\"Yes,No\",\"answer_text__c\":\"No\",\"answer_value__c\":null}],\"count\":2,\"display\":\"t\",\"location\":{\"tdlinx_outlet_city__c\":\"Huntington Beach\",\"tdlinx_outlet_zip_code__c\":\"926468331\",\"tdlinx_outlet_state__c\":\"CA\",\"tdlinx_outlet_addr__c\":\"22111 Luau Ln\",\"billingstate\":\"CA\",\"billingcountry\":null,\"billingpostalcode\":\"926468331\",\"billingcity\":\"Huntington Beach\",\"billingstreet\":\"22111 Luau Ln\",\"sfid\":\"001K000000pW7oaIAC\",\"tdlinx_outlet_desc__c\":\"Diageo\",\"name\":\"Diageo test very long name on Account when text wrapper\",\"distance\":379.60952550137864},\"contact__c\":\"003K000000hWUvGIAW\",\"account__c\":\"001K000000pW7oaIAC\",\"survey_id\":1,\"upc__c\":\"1234\",\"manually_entered_upc_description__c\":\"asdfasdf\",\"manually_entered_brand_desc__c\":\"asdf\",\"manually_entered_base_size__c\":\"0.07L\"}]");
			
			SurveyDBManager manager = new SurveyDBManager();
			manager.createSurvey15(body, externalId);
			
			ArrayNode submissions = manager.getSurveySubmissions(externalId);
			
			Assert.assertEquals(1, submissions.size());
			
			ObjectNode submission = (ObjectNode) submissions.get(0);

			System.out.println(submission);
			/*
			Assert.assertEquals(32, submission.get("score__c").asInt());
			Assert.assertEquals(29, submission.get("total_actual_score__c").asInt());
			Assert.assertEquals(externalId, submission.get("external_id__c").asText());
			Assert.assertEquals(90, submission.get("total_possible_score__c").asInt());
			Assert.assertEquals("seriously?", submission.get("grade__c").asText());
			Assert.assertEquals("003K000000hWUvGIAW", submission.get("contact__c").asText());
			*/
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
}