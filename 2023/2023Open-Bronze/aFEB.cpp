#include <iostream>
#include <string>
using std::string;
using std::cin; 
using std::cout; 


int main() {
	int N; 
	cin >> N; 

	string S; 
	cin >> S;

	// for (int i = 0; i < N; i++)
	// {
	// 	cout << i << ": "<< S[i] << std::endl;
	// }

	bool everything_possible = (S[0]=='F') or (S[N-1]=='F');
	// cout << "everything possible: "<< everything_possible << std::endl;

	int min = 0;
	char last_char = S[0];
	for (int i = 1; i < N; i++)
	{
		if(last_char == 'F') { //skip until we have a non-F
			last_char = S[i];
		}
		else {
			if(S[i] == 'F') {
				if (last_char == 'B')
				{
					last_char = 'E';
				}
				else {
					last_char = 'B';
				}
			}
			else if (S[i] == 'B') {
				if(last_char == 'B'){
					min++;
				}
				last_char = 'B';
			}
			else { // S[i] == 'E'
				if(last_char == 'E'){
					min++;
				}
				last_char = 'E';
			}
		}
	}	
	// cout << "min: " << min << std::endl;

	int max = 0;
	last_char = S[0];
	for (int i = 1; i < N; i++)
	{
		if(last_char == 'F') { //skip until we have a non-F
			max++;
			last_char = S[i];
		}
		else {
			if(S[i] == 'F') {
				max++;
				last_char = last_char; //stayed the same
			}
			else if (S[i] == 'B') {
				if(last_char == 'B'){
					max++;
				}
				last_char = 'B';
			}
			else { // S[i] == 'E'
				if(last_char == 'E'){
					max++;
				}
				last_char = 'E';
			}
		}
	}	
	// cout << "max: " << max << std::endl;

	// cout << "solution: " << std::endl;;

	int inc = 2 - everything_possible; //if possible, then 1; if not, then 2
	cout << 1+(max-min)/inc << std::endl;
	for (int i = min; i <= max; i+=inc)
	{
		cout << i << std::endl;
	}

}