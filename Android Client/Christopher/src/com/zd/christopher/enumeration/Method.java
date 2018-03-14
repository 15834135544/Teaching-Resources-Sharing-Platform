package com.zd.christopher.enumeration;

public class Method
{
	public interface IMethodEnum
	{
		public String getMethod();
	}
	
	public enum CourseMethod implements IMethodEnum
	{
		ADD("_add"),
		DELETE("_deleteCourseById"),
		UPDATE_COURSE_BY_ID("_updateCourseById"),
		FIND_COURSE_BY_ID("_findCourseById"),
		FIND_COURSES("_findCourses"),
		FIND_IDS("_findIds"),
		FIND_NAMES("_findNames"),
		FIND_CREDITS("_findCredits"),
		FIND_SEMESTERS("_findSemester"),
		FIND_PERIODS("_find_periods"),
		FIND_INSTRUCTORS("_findInstructors"),
		FIND_INSTITUTIONS("_findInstitutions");
			
		private String method;
			
		private CourseMethod(String method)
		{
			this.method = method;
		}
			
		public String getMethod()
		{
			return method;
		}
	}
	
	public enum FacultyMethod  implements IMethodEnum
	{
		ADD_FACULTY("_addFaculty"),
		DELETE_FACULTY_BY_ID("_deleteFacultyById"),
		UPDATE_FACULTY_BY_ID("_updateFacultyById"),
		FIND_FACULTY_BY_ID("_findFacultyById"),
		FIND_FACULTIES("_findFaculties"),
		FIND_IDS("_findIds"),
		FIND_NAMES("_findNames"),
		FIND_INSTITUTIONS("_findInstitutions"),
		FIND_TITLES("_findTitles"),
		FIND_POSITIONS("_findPositions"),
		FIND_BIRTHDAYS("_findBirthdays"),
		FIND_GENDERS("_findGenders"),
		FIND_EMAILS("_findEmails"),
		FIND_PHONES("_findPhones"),
		FIND_FAXES("_findFaxes"),
		FIND_ADDRESSES("_findAddress"),
		FIND_ZIPCODES("_findZipCode"),
		FIND_CONUTRIES("_findCountries"),
		FIND_NATIONALITIES("_findNationalities"),
		FIND_IDCARDS("_findIdCards");
			
		private String method;
			
		private FacultyMethod(String method)
		{
			this.method = method;
		}
			
		public String getMethod()
		{
			return method;
		}
	}
	
	public enum StudentMethod  implements IMethodEnum
	{
		ADD_STUDENT("_addStudent"),
		DELETE_STUDENT_BY_ID("_deleteStudentById"),
		UPDATE_STUDENT_BY_ID("_updateStudentById"),
		FIND_STUDENT_BY_ID("_findStudentById"),
		FIND_STUDENTS("_findStudents"),
		FIND_IDS("_findIds"),
		FIND_NAMES("_findNames"),
		FIND_INSTITUTIONS("_findInstitutions"),
		FIND_BIRTHDAYS("_findBirthdays"),
		FIND_GENDERS("_findGenders"),
		FIND_EMAILS("_findEmails"),
		FIND_PHONES("_findPhones"),
		FIND_FAXES("_findFaxes"),
		FIND_ADDRESSES("_findAddress"),
		FIND_ZIPCODES("_findZipCode"),
		FIND_CONUTRIES("_findCountries"),
		FIND_NATIONALITIES("_findNationalities"),
		FIND_IDCARDS("_findIdCards");
			
		private String method;
			
		private StudentMethod(String method)
		{
			this.method = method;
		}
			
		public String getMethod()
		{
			return method;
		}
	}
	
	public enum UserMethod  implements IMethodEnum
	{
		ADD("_add"),
		DELETE("_delete"),
		UPDATE("_update"),
		FIND_USER_BY_ID("_findUserById"),
		FIND_USERS("_findUsers"),
		FIND_IDS("_findIds"),
		FIND_PASSWORDS("_findPasswords"),
		FIND_ENCRYPTEDPASSWORDS("_findEncryptedPasswords"),
		FIND_NAMES("_findNames"),
		FIND_FAVORITES("_findFavorites"),
		FIND_AVATARS("_findAvatars");
			
		private String method;
			
		private UserMethod(String method)
		{
			this.method = method;
		}
			
		public String getMethod()
		{
			return method;
		}
	}
	
	public enum ServiceMethod  implements IMethodEnum
	{
		;
		
		private String method;
		
		private ServiceMethod(String method)
		{
			this.method = method;
		}
		
		public String getMethod()
		{
			return method;
		}
	}
}

