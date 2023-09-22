import { Note } from "./Note";

export interface User{
    fname: String;
    lname: String;
    email: String;
    notes: Array<Note>;
}