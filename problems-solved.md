# List of Problems

### 알고리즘 문제풀이 테이블

| No.  | 문제 링크                             | 나의 접근 방식                                               | 올바른 접근 방식                                             |
| ---- | ------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | https://www.acmicpc.net/problem/11654 | 처음에는 Buffered Writer 를 사용하려 했음                    | char 를 int 로 형변환 하여 System.out으로 출력한다           |
| 2    | https://www.acmicpc.net/problem/11720 | char 를 int 로 변환할 방법을 찾았는데, 이는 바보같은 짓이었다. | char -> int 형변환 -> 빼기 48 해주면 원래의 숫자를 얻을 수 있다. |
| 3    | https://www.acmicpc.net/problem/10809 | Map 에 담아서 중복이 없는지 확인하는 방식.                   | String.indexOf() 함수를 사용하면 찾았을 때는 첫번째 인덱스를 반환해주고, 못찾으면 -1을 반환해준다. 2줄 안에 끝나는 문제. |
| 4    | https://www.acmicpc.net/problem/2675  | 인풋 주어진대로 반복한다                                     | 인풋 주어진대로 반복한다                                     |
| 5    | https://www.acmicpc.net/problem/1157  | Map 에 문자를 넣어 등장 횟수를 센다. 등장 횟수 중 최대를 찾아 해당 문자를 출력 or 최대가 여러개면 '?'를 출력한다. | Map 을 사용하지 않아도 되었다.                               |
| 6    | https://www.acmicpc.net/problem/1152  | trim() -> 공백 아닌 문자만 리스트에 담아서 리스트 길이 반환  | trim 하거나 StringTokenizer 이용. 별도의 list 말고 바로 int 변수로 개수 세서 해당 변수만 프린트. |
| 7    | https://www.acmicpc.net/problem/2908  | StringBuilder 의 reverse 함수 사용                           | reverse 하는 방식은 다양한데, 대소비교 출력은 Math.max 를 사용하는게 깔끔함. |
| 8    | https://www.acmicpc.net/problem/5622  | `dial[][]` 을 만들어서 번호와 번호에 대응하는 문자, 번호 누르는 시간을 담았다. | Switch-Case 문 사용하기 (?)                                  |
| 9    | https://www.acmicpc.net/problem/2941  |                                                              |                                                              |
| 10   | https://www.acmicpc.net/problem/1316  |                                                              |                                                              |
|      |                                       |                                                              |                                                              |

