#include <iostream>
// #include <string>

using namespace std;

int main() {
    int N;
    cin >> N;
    cout << "N: " << N << "\n";
    char s[N];
    cin >> s;

    bool G_run = (s[0] == 'G');
    // cout << "bool: " << G_run << "\n"; 
    int x = 1;

    bool firstRun = true;
    int firstRunLength = 0;
    int curRunLength = 0; //will also save last run lenght

    for (int i=0; i<N; i++) {
        cout << s[i] << "\n";
        curRunLength++;

        if((i!=N-1) && s[i] != s[i+1]) {
            x++;
            cout << curRunLength;
            if(firstRun) {
                firstRunLength = curRunLength;
                firstRun = false;
            }
            curRunLength = 0;
        }
    }

    cout << "x: " << x << "\n";
    cout << "first run length: " << firstRunLength << "\n";
    cout << "last run length: " << curRunLength << "\n";

    cout << "N: "<< N << "\n";
    int total = (N-2)*(N-1)/2; //(n-2) + (n-3)+....0
    cout << "total: " << total << "\n";

    int illegal = (N-firstRunLength)-(x-1) + (N-curRunLength) - (x-1);



    cout << total - illegal;


    // If there are X sequences. 
    // Then the number of illegal sequences is 
    // (N-s[0]) - (X-1) + (N-s[-1]) - (X-1)
    
}