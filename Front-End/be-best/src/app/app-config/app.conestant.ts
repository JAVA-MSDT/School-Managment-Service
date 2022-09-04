import { ROUTER_PATH } from './router-path-const';

export const LANG_CONSTANTS = {
  LANG_ATTR: 'language',
  EN: 'en',
  PL: 'pl',
};

export const HTTP_CONSTANTS = {
  CONTENT_TYPE: 'content-type',
  APPLICATION_JSON: 'application/json',
  GET: 'GET',
  POST: 'POST',
  PUT: 'PUT',
  DELETE: 'DELETE',
};
export const FILE_CONSTANTS = {
  CONTENT_TYPE: 'content-type',
  APPLICATION_JSON: 'application/json',
};

export const AUTH_CONSTANTS = {
  JWT_KEY: 'contact-manager-jwt',
};

export const API_NAME = {
  PRIVATE: 'pr',
  PUBLIC: 'pu',
  TRAININGS: 'trainings',
  SUBJECTS: 'subjects',
  USERS: 'users',
  PUBLIC_INFO: 'public-info',
  TEACHERS: 'teachers',
};

export const API_PATH_NAME = {
  TRAININGS_PUBLIC_PATH:
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.TRAININGS +
    ROUTER_PATH.contextPath,

  SUBJECTS_PUBLIC_PATH:
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.SUBJECTS +
    ROUTER_PATH.contextPath,

  USERS_PUBLIC_PATH:
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.USERS +
    ROUTER_PATH.contextPath,
};
