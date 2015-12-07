#include <stdio.h>
#include <string.h>

void printString(char* str);
void reverse(char* str);

int
main() {
    //char* test = "cool"; // puts in read-only memory!
    //don't do this!

    // http://stackoverflow.com/questions/11229477/are-all-char-arrays-automatically-null-terminated
    char test[6] = "hello\0";
    printf("%s\n", test);
    
    /*
     * test is pointer so memory address -> base address
     * dereferencing gives us value at memory address
     *
     * printf("%d\n", test);
     * printf("%c\n", *test);
     * printf("%d\n", test + 1);
     * printf("%c\n", *(test + 1));
     */

    reverse(test);
    printf("%s\n", test);
}

void printString(char* str) {
    for (int i = 0; i < strlen(str); i++) {
        if (str[i] != '\0') {
            printf("%c", str[i]);
        }
    }
    printf("\n");
}

void reverse(char* str) {
    int mid = strlen(str) / 2;
    for (int i = 0; i < mid; i++) {
        int opp = strlen(str) - 1 - i;
        char temp = *(str + i);
        *(str + i) = *(str + opp);
        *(str + opp) = temp;

        //char temp = str[i];
        //str[i] = str[opp];
        //str[opp] = temp;
    }
}
