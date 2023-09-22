#include <stdio.h>

char setGrade(int mark);

int main() 
{
    int numOfStudent, numOfCourses, studentId, mark, totalMark;
    float averageMark;

    // open file
    FILE *fileWriter;
    fileWriter = fopen("students.dat", "a");

    if (fileWriter == NULL) {
        printf("Failed to open file");
    }

    // main program
    printf("SIMPLE GRADING SYSTEM\n\n");

    printf("Enter no. of students: ");
    scanf("%d", &numOfStudent);

    printf("Enter no. of courses: ");
    scanf("%d", &numOfCourses);
    
    // loop through number of students
    for (int i=0; i < numOfStudent; i++) {
        // set total and average mark to 0
        totalMark = 0;
        averageMark = 0.0;

        printf("\n\tEnter student ID: ");
        scanf("%d", &studentId);

        // write student id into FILE
        fprintf(fileWriter, "Student ID: %d\n", studentId);

        printf("\tEnter marks for student %d: \n", studentId);

        // loop through number of courses
        for (int j =0; j < numOfCourses; j++) {
            printf("\t\tEnter mark for course #%d: ", j + 1);
            scanf("%d", &mark);

            // error handling for mark
            if (mark < 0 || mark > 100) {
                printf("\t\tMark not valid ! Please reinsert mark for course #%d: ", j+1);
                scanf("%d", &mark);
            }

            totalMark += mark;

            // write mark into FILE
            fprintf(fileWriter, "Mark for course #%d: %d\n", j+1, mark);

            char grade = setGrade(mark);
            printf("\t\tGrade: %c\n\n", grade);
            // write grade for mark into FILE
            fprintf(fileWriter, "Grade: %c\n", grade);

        }

        // print total and average mark
        printf("\t\tTotal marks = %d\n", totalMark);

        averageMark = (float)totalMark / numOfCourses;
        printf("\t\tAverage Mark = %0.2f\n\n", averageMark);

        if (averageMark >= 40) {
            printf("\tPROCEED TO THE NEXT SEMESTER...\n\n");
        } else {
            printf("\tFAILED TO PROCEED TO THE NEXT SEMESTER...\n\n");
        }

        // write total and average mark into FILE
        fprintf(fileWriter, "Total Marks = %d\nAverage Mark = %0.2f\n\n", totalMark, averageMark);
    }

    // close FILE
    fclose(fileWriter);
    return 0;

}

char setGrade(int mark)
{
    char grade = 'F';

    if (mark >= 80 && mark <= 100)
    {
        grade = 'A';
    } else if (mark >= 70 && mark <= 79)
    {
        grade= 'B';
    } else if (mark >= 60 && mark <= 69)
    {
        grade= 'C';
    } else if (mark >= 50 && mark <= 59)
    {
        grade= 'D';
    } else if (mark >= 40 && mark <= 49)
    {
        grade= 'E';
    } else if (mark >= 0 && mark <= 39)
    {
        grade= 'F';
    }

    return grade;
}