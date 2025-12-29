import { useQuery } from '@tanstack/react-query';

import type { PageRequest } from '@/types/api';
import { userApi } from '@/api/userApi';

export const useUsers = (keyword?: string, pageRequest?: PageRequest) => {
	return useQuery({
		queryKey: ['users', keyword, pageRequest],
		queryFn: () => userApi.searchUsers(keyword, pageRequest),
		placeholderData: (previousData) => previousData, // Keep previous data while fetching new page
	});
};

export const useUser = (id: number) => {
	return useQuery({
		queryKey: ['users', id],
		queryFn: () => userApi.getUser(id),
		enabled: !!id,
	});
};
