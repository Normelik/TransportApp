import axios from 'axios';
import { data } from 'react-router-dom';

type PropsLogin = {
  username: String;
  password: String;
};

type PropsCreateShipment = {
  unloadingPlace: string;
  unloadingTime: string;
  plateNumber: string;
  text: string;
  duration: number;
  isBooked: boolean;
};

const BASE_URL = 'http://localhost:8080/';
export const API = {
  login: async ({ username, password }: PropsLogin) => {
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
      const response = await axios.get(`${BASE_URL}api/shipments`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });
      return response.data;
    } catch (error) {
      console.error('Error fetching shipments:', error);
      throw error;
    }
  },

  createShipment: async ({
    unloadingPlace,
    unloadingTime,
    plateNumber,
    duration,
    text,
  }: PropsCreateShipment) => {
    try {
      const response = await axios.post(`${BASE_URL}api/shipments`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        data: {
          unloadingPlace: { unloadingPlace },
          unloadingTime: { unloadingTime },
          plateNumber: { plateNumber },
          text: { text },
          duration: { duration },
          isBooked: true,
        },
      });
      return response.data;
    } catch (error) {
      console.error('Error fetching shipments:', error);
      throw error;
    }
  },

  deleteShipment: async (id: number) => {
    try {
      const response = await axios.delete(`${BASE_URL}api/shipments/${id}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
      });
      return response.data;
    } catch (error) {
      console.error('Error deleting shipment:', error);
      throw error;
    }
  },
};
