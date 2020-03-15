## Red Black Tree : Insertion & Deletion 
레드블랙 트리는 이진 검색트리이다. 각 노드당 한 피트의 추가 기억 공간을 갖는데, 이 공간에는 red, black 의 값을 할당한다. 
루트에서 리프까지의 경로에 나타나는 **노드의 색깔을 제한함으로써 그러한 경로 중 어떠한것도 다른 것 보다 두 배 이상 길지 않음을 
보장한다.** 이로써 트리는 **근사적으로 균형을 이룬 트리**가 된다. 

#### 노드의 필드
* color 
* key 
* left
* right 
* parent 

#### 레드블랙 특성
다음과 같은 특성을 만족하는 **이진 검색 트리**를 레드블랙 트리라고 한다.
1. 모든 노드는 적색이거나 흑색이다. 
2. **루트는 흑색**이다. 
3. **모든 리프는 흑색**이다. 
4. 노드가 적색이면 그 노드의 자식은 모두 흑색이다. 
5. 각 노드로부터 그 노드의 자손인 리프로 가는 경로들은 모두 **같은 수의 흑색 노드**를 포함한다.

#### 정리 
```
* ALWAYS 흑색 : 루트, 모든 리프, 적색 노드의 자식 
* NOT ALWAYS 적색 
* 적색과 적색이 만나는 경우 문제가 된다. 
```

#### 추가 정보 
* **Sentinel (경계노드)** : 한계 조건을 다루기 편하도록 NIL 을 표현하기 위해 하나의 경계노드를 사용한다. 트리의 T 에 
있어서 경계 노드 T.nil 은 트리의 다른 보통 노드와 마찬가지로 동일한 필드를 가진다. 이 노드의 color 필드는 흑색 이지만 
p, left, right, key 필드 값들은 의미를 갖지 않는다. 모든 리프와 루트의 부모를 T.nil 로 표현한다. 

* **bh(x)** : 노드 x 에서 리프까지의 경로에 있는 모든 흑색 노드 (x 자신은 제외)의 개수를 그 노드의 **black-height**라 하고
이를 bh(x) 로 표시한다. 

* **보조정리** (왜 레드블랙 트리가 좋은 검색 트리인지)
```
n개의 내부 노드를 가지는 레드블랙 트리는 최대 2lg(n+1) 의 높이를 가진다. 
```
레드블랙 트리는 균형잡힌 트리임을 알 수 있다. 최대 높이가 log~ 이므로

### 레드블랙 트리에 필요한 연산들 

#### 회전 
트리에서 삽입 삭제가 이루어지면 트리를 수정하게 되므로 1~5 까지의 레드블랙 특성을 위반할 수 있다. 이런 특성을 복구해 주기 
위해서 트리 내의 일부 노드들의 색깔과 포인터를 변경해 주어야 한다. 
<br/><br/>
포인터를 변경하기 위해 회전을 사용하는데, 이것은 이진 검색 트리의 특성을 보정해주는 국소적인 연산이다. 
* [회전의 수도코드](./right-rotate.md)
* Left rotate, right rotate 모두 O(1) 시간에 수행된다. 회전을 통해 포인터만 변경되며 다른 필드는 그대로 유지된다.

#### 삽입 
* 노드 삽입은 O(logN) 시간에 수행된다. 
* 보통의 이진검색 트리처엄 노드 z 를 트리 T 에 삽입한 뒤 z 를 **적색으로** 칠한다. (T.nil은 어차피 흑색)
* 레드블랙 특성을 유지하기 위해 RB-INSERT-FIXUP 을 호출해 노드의 색깔을 바꾸고 회전을 수행한다. 
* RB-INSERT(T,z) 가 호출되면 노드 z 가 트리 T 에 삽입되며, 이 때 노드의 key 는 이미 채워져 있다고 가정한다. 

#### RB-INSERT
```
RB-INSERT(T, z){
    y = T.nil 
    x = T.root
    while(x != T.nil){
        y = x
        if(z.key < x.key){
            x = x.left
        }else{
            x = x.right
        }
    }
    z.parent = y
    if(y == T.nil){
        T.root = z
    }else if(z.key < y.key){
        y.left = z
    }else{
        y.right = z
    }
    z.left = T.nil
    z.right = T.nil 
    z.color = RED

    RB-INSERT-FIXUP(T,z)
}
``` 

#### RB-INSERT-FIXUP

```
RB-INSERT-FIXUP(T, z){
    while(z.parent.color == RED){
        if(z.parent == z.parent.parent.left){
            y = z.parent.parent.left
            if(y.color == RED){ 
//경우 1 : z 의 삼촌 y 가 적색인 경우  
                z.parent.color = BLACK
                y.color = BLACK
                z.parent.parent.color = RED
                z = z.parent.parent
            }else {
                if(z == z.parent.right){
//경우 2 : z 의 삼촌 y 가 흑색이며 z 가 오른쪽 자식인 경우 
                z = z.parent
                LEFT-ROTATE(T, z)
                }
//경우 3 : z 의 삼촌 y 가 흑색이며 z 가 왼쪽 자식인 경우 
                z.parent.color = BLACK
                z.parent.parent.color = RED
                RIGHT-ROTATE(T, z.parent.parent)
            }
        }else{
            위의 if 문에서 right 와 left 를 바꾼 경우와 동일하다. 
        }
    }//end of while 
}
```

#### 삭제 
* 노드가 n 개인 레드블랙 트리에 대한 다른 기본 연산과 마찬가지로 한 노드를 삭제하는 연산은 O(logN) 시간에 수행된다. 
* 이진 검색 트리의 TREE-DELETE 프로시저의 서브루틴인 TRANSPLANT를 레드블랙 트리에 적용할 수 있도록 수정해야 한다. 

#### RB-TRANSPLANT
* v 노드를 u 의 자리에 넣는 과정 
```
RB-TRANSPLANT(T, u, v){
    if(u.p == T.nil){
        T.root = v 
    }
    else if(u == u.p.left){
        u.p.left = v
    }
    else{
        u.p.right = v
    }
    v.p = u.p
}
```
* 이진 검색 트리와 다른 점 
    * NIL 대신 T.nil 를 참조한다. 
    * v.p 에 값이 조건 없이 할당된다. 