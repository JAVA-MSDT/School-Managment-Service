import { Subject } from "../training/subject";
import { Address } from "./address";
import { Role } from "./role";

export interface User {
    id?: string;
    firstname: string;
    middlename: string;
    lastname: string;
    username: string;
    email: string;
    phonenumber: string;
    dateofbirth: string;
    address: Address;
    role: Role;
    subjects: Subject[];
    users:User[];
  }