#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main() {
    char line[256];
    char first_char[2];
    char rest_of_line[256];
    int password = 0;
    int current = 50;

    FILE* file = fopen("inputs/1.input", "r");

    while (fgets(line, sizeof(line), file)) {
        strncpy(first_char, line, 1);
        strncpy(rest_of_line, line + 1, strlen(line) - 1);
        
        if (first_char[0] == 'R') {
            current = (current + atoi(rest_of_line)) % 100;
        }

        if (first_char[0] == 'L') {
            current = (current - atoi(rest_of_line)) % 100;
        }

        if (current == 0) {
            password += 1;
        }
    }

    printf("%d", password);

    fclose(file);
}   