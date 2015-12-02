# Course Searching Website

This website is the demo of team project, students can use it to enroll in courses 
and teacher can add new courses in it.

the EBTs are fulfillment, support and compliance.

And it includes the BOs like AnyTask, AnyImpact, AnyForm, AnyInterface, AnyCategory, AnyAspect.



## login

1. You can log in with student account or teacher account.
2. Student and Teacher are the IOs of AnyParty who use this system.
3. If you log in with the teacher account, you can add new course in the database.
4. If you log in with the student account, you can search courses.
5. Course are the IO of AnyEntity.
6. This website has a simple user interface.

## Search

1. Searching is the IO of the AnyTask.
2. After you search a keyword, the website will list the result.
3. Clicking the button can make you enroll in this course.
4. The enrollment is the IO of the AnyImpact
5. The Course has the attribute department, which is the type of the Course. This 
CourseType is the IO of AnyType
6. After enrolling in several course, you can see your schedule. This is the form that this system 
produced. And it is the IO of the AnyForm.
7. And there is a rule to constrain the enrollment process. One student can only enroll in 
no more than 4 courses. This rule is the IO of the AnyRule.
8. When you have searched several times, you can see your searching history. This is a kind of log 
that is stored in the system. The searching history is the IO of the AnyLog.
