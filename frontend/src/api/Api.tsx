import axios from 'axios';

type Props = {
  username: String;
  password: String;
};

const BASE_URL = 'http://localhost:8080/';
export const API = {
  login: async ({ username, password }: Props) => {
    try {
      const response = await axios.post(`${BASE_URL}login`, {
        username,
        password,
      });
      return response.data;
    } catch (error) {
      console.error('Login failed:', error);
      throw error;
    }
  },

  getShipments: async () => {
    try {
      const response = await axios.get(`${BASE_URL}api/shipments`);
      return response.data;
    } catch (error) {
      console.error('Error fetching shipments:', error);
      throw error;
    }
  },
};
