package com.example.demo.controller

import static org.mockito.Mockito.when

import org.codehaus.groovy.util.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.StringUtils
import org.springframework.web.context.WebApplicationContext

import com.example.demo.domain.entity.Department
import com.example.demo.domain.entity.Employee
import com.example.demo.domain.service.EmployeeService

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest extends Specification {

	@SpyBean
	private EmployeeService employeeService

	@Autowired
	MockMvc mockMvc

	@Unroll
	def "EmployeeController - 正常系 - 2件の社員が返る"() {

		given:
		def department = new Department("001", "部署A");
		def employeeList = new ArrayList<Employee>() { {
						this.add(new Employee("00000001", "社員A", department));
						this.add(new Employee("00000002", "社員B", department));
					}
				}
		def jsonBuilder = new JsonBuilder(employeeList)
		def jsonSlurper = new JsonSlurper()

		when:
		def actual = mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andReturn().getResponse()

		then:
		actual.getStatus() == HttpStatus.OK.value
		jsonSlurper.parseText(actual.getContentAsString()) == jsonSlurper.parseText(jsonBuilder.toPrettyString())
	}

	@Unroll
	def "EmployeeController - 正常系 - 何も返らない"() {

		given:
		when(employeeService.getEmployees()).thenReturn(null)

		when:
		def actual = mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andReturn().getResponse()

		then:
		actual.getStatus() == HttpStatus.NO_CONTENT.value
		actual.getContentAsString() == ""
	}
}