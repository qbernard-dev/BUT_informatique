#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>

#define MAX_LOGIN_LENGTH 20
#define MAX_PASSWORD_LENGTH 30
#define MAX_USERS 100

typedef struct { char login[MAX_LOGIN_LENGTH], password[MAX_PASSWORD_LENGTH]; } User;
User users[MAX_USERS]; int num_users = 0;

char *generate_password() {
    static const char charset[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+{}|:<>?-=[]\\;,./";
    static const int charset_size = sizeof(charset) - 1;
    char *password = malloc(MAX_PASSWORD_LENGTH * sizeof(char));
    srand((unsigned int) time(NULL));
    for (int i = 0; i < MAX_PASSWORD_LENGTH - 1; i++) { 
        password[i] = charset[rand() % charset_size]; 
    }
    password[MAX_PASSWORD_LENGTH - 1] = '\0';
    return password;
}

bool add_user(char *login, char *password) {
    if (num_users >= MAX_USERS) { printf("Maximum number of users reached.\n"); return false;}
    for (int i = 0; i < num_users; i++) { 
        if (strcmp(users[i].login, login) == 0) { 
            printf("Login already exists.\n"); return false;
        }
    }
    User user; strcpy(user.login, login); strcpy(user.password, password); users[num_users++] = user;
    printf("User added successfully.\n");
    return true;
}

void print_users() {
    for (int i = 0; i < num_users; i++) { 
        printf("%s\t%s\n", users[i].login, users[i].password);
    }
}

int main() {
    int choice;
    do {
        printf("\n1. Add user\n2. Print users\n3. Quit\nEnter your choice: "); scanf("%d", &choice);
        switch (choice) {
            case 1: {
                char login[MAX_LOGIN_LENGTH];
                printf("Enter login: "); scanf("%s", login);
                char *password = generate_password();
                if(!add_user(login, password)){break;};
                printf("Generated password: %s\n", password);
                free(password);
                break;
            }
            case 2: { print_users(); break; }
            case 3: { printf("Exiting program.\n"); break; }
            default: { printf("Invalid choice. Please try again.\n"); break; }
        }
    } while (choice != 3);
    return 0;
}
