#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void main() {
    char line[256];

    int password = 0;
    int current = 50;
    int prev = 50;

    FILE* file = fopen("inputs/1.input", "r");

    while (fgets(line, sizeof(line), file)) {
        char first_char = line[0];
        int rest_of_line = atoi(line + 1);

        if (first_char == 'R') {
            current += rest_of_line;
        } else if (first_char == 'L') {
            current -= rest_of_line;
        }

        if (prev != 0 || rest_of_line >= 100) {
            password += abs(current / 100);
            if (current < 0 && current % 100 != 0) {
                password++;
            }

            if (prev == 0 && rest_of_line > 100 && first_char == 'L') {
                password--;
            }
        }

        if (current <= 0 && ((current % 100) + 100) % 100 == 0) {
            password++;
        }

        current = ((current % 100) + 100) % 100;
        prev = current;
    }

    printf("%d\n", password);

    fclose(file);
}