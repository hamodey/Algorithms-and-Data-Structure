public class ListVisualiser {
    SLList List;
    int line;
    public ListVisualiser(SLList l) {
        this.List = l;
    }
    public void visualise() {
//        Whenever we call the visualise() method, we set the class variable line to 0. (as we start the sequence of writing down the list)
        this.line = 0;
//        We also call the "traverseList", a recursive function, initially with an argument of the whole list.
        traverseList(this.List);
    }

//    In short, this method has 3 sections: default action, condition when it goes to the end of the list, and a condition when it doesn't
//    .. but each section does something different depending on which line of visualiser are we outputing
    private void traverseList(SLList currentList){
//        This is, let's call it, a section 1 - default action:
//        The default action is different depending on which line of outputting the list it is ..
//      If it's line 0 - start (or carry on) outputting box for ".first()" of our current node.
        if (this.line == 0){
            System.out.print("[*|");
        }
//        If it's line 1: just write the vertical bar and a bunch of spaces
        else if (this.line == 1){
            System.out.print(" |       ");
        }
//        If it's line 2: write the actual value of the .first()
        else if (this.line == 2 ){
//            .. hovewer, we also need to take care of the spacing ..
            int numOfSpaces = 9; // by default, there are  9 spaces between the 2 v. bars.
            int numberLength = currentList.first().toString().length(); //  but the number can have different length (like 1 and 100)
            numOfSpaces = numOfSpaces-numberLength; // so we change the number of spaces after the value to 9 minus whatever the length of the number is
            System.out.print(currentList.first().toString()); // then we output the value.
//           And then below we just print the rest of spaces to align to next v. bar
            for (int i = 0; i < numOfSpaces; i++) {
                System.out.print(' ');
            }
        }
//        ----------- end of section 1-----
//        Section 2: case when we came to the end of the whole list.
        if (currentList.rest() == currentList.NIL) {
//            When it's line 0, display the "/]" bit and go to new line
            if (this.line == 0){
                System.out.print("/] \n");
            }
//            Otherwise, just go to a new line
            else {
                System.out.print("\n");
            }
//            Then we globally add 1 to our "line" class variable.
            this.line++;
//            and if only we aren't after line 3, do the whole recursive method again with the whole list (so that we draw next line of it)
            if (this.line < 3){
                traverseList(this.List);
            }
        }
//        Section 3: case when we haven't reached the end of the whole list yet.
//          ..Basically, just call the method recursively with one "deeper" of our list, but if it's also line 0, then additionaly we display the "*] ->" bit.
        else {
            if (this.line == 0){
                System.out.print("*] -> ");
            }
            traverseList(currentList.rest());
        }
    }
}
