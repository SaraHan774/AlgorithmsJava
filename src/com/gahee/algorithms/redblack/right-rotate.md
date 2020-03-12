## Red-Black Tree 

### Rotate 수도코드 

#### Right Rotate 

```
//Tree 의 루트와 돌리는 기준점을 x로 받는다. 
RIGHT-ROTATE(T, x){
    x = y.left //오른쪽으로 회전하는 것이므로 오른쪽이 더 길다. 따라서 기준점의 왼쪽을 찾아야 한다. 
    
//=== 나의 자식을 바꾸고, 그 자식에게 부모 바뀐 것 알려주기 ===
    y.left = x.right //y에는 원래 x가 갖던 오른쪽 자식을 매단다. 
    if(x.right != T.nil){ //만약 x.right 가 nil이 아니었다면 
        x.right.p = y //부모가 y로 바뀌었음을 알려준다.     
    }
    
//=== 나의 부모 바꾸고, 부모에게 내가 바뀐 것 알려주기 ===
    x.p = y.p //y가 갖던 부모를 x에게 준다
    if(y.p == T.nil){
        //(1)만약 y 가 root 였다면 
        T.root = x //x 를 root 로 설정한다. 
    }
    else if(y == y.p.right){
        //(2)만약 y가 부모의 오른쪽 자식이었다면 
        y.p.right = x //오른쪽 자식이 x로 바뀐다. 
    }
    else{
        //(3)y가 부모의 왼쪽 자식인 경우이므로 
        y.p.left = x //왼쪽 자식이 x로 바뀐다. 
    }

    x.right = y //x의 오른쪽 자식은 y가 되고 
    y.p = x //y의 부모는 x가 된다. 
}
```

* left rotate 는 이의 반대로 이루어진다. 