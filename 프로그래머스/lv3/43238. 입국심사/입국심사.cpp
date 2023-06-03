#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    sort(times.begin(), times.end());
    
    long long start = 1, end = (long long)times[times.size()-1]*n;
    
    while(start<=end){
        
        long long mid = (start + end)/2;
        long long sum = 0;
        
        for(int i = 0;i<times.size();i++){
            sum += (mid/times[i]);
        }
        
        if(sum >= n){
            end = mid - 1;
            answer = mid;
        }else{
            start = mid + 1;
        }
        
    }
    
    
    return answer;
}