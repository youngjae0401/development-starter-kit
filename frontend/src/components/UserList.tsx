import { useState } from 'react';

import { useUsers } from '@/hooks/useUsers';

export const UserList = () => {
	const [keyword, setKeyword] = useState('');
	const [page, setPage] = useState(0);
	const { data, isLoading, error } = useUsers(keyword, { page, size: 20 });

	if (isLoading) return <div className="text-center p-4">Loading...</div>;
	if (error) return <div className="text-red-500 p-4">Error: {error.message}</div>;
	if (!data) return null;

	return (
		<div className="p-4 max-w-4xl mx-auto">
			<h1 className="text-2xl font-bold mb-4">User List</h1>

			<div className="mb-4">
				<input
					type="text"
					placeholder="Search users..."
					value={keyword}
					onChange={(e) => setKeyword(e.target.value)}
					className="w-full border p-2 rounded shadow-sm focus:ring-2 focus:ring-blue-500 outline-none"
				/>
			</div>

			<div className="overflow-x-auto">
				<table className="min-w-full bg-white border border-gray-200 shadow-sm rounded-lg">
					<thead className="bg-gray-50">
						<tr>
							<th className="border-b p-3 text-left font-semibold text-gray-700">ID</th>
							<th className="border-b p-3 text-left font-semibold text-gray-700">Email</th>
							<th className="border-b p-3 text-left font-semibold text-gray-700">Name</th>
							<th className="border-b p-3 text-left font-semibold text-gray-700">Status</th>
							<th className="border-b p-3 text-left font-semibold text-gray-700">Created At</th>
						</tr>
					</thead>
					<tbody className="divide-y divide-gray-200">
						{data.content.map((user) => (
							<tr key={user.id} className="hover:bg-gray-50">
								<td className="p-3 text-gray-800">{user.id}</td>
								<td className="p-3 text-gray-600">{user.email}</td>
								<td className="p-3 text-gray-800 font-medium">{user.name}</td>
								<td className="p-3">
									<span
										className={`px-2 py-1 rounded text-xs font-semibold ${
											user.status === 'ACTIVE'
												? 'bg-green-100 text-green-800'
												: 'bg-gray-100 text-gray-800'
										}`}
									>
										{user.status}
									</span>
								</td>
								<td className="p-3 text-gray-500 text-sm">
									{new Date(user.createdAt).toLocaleDateString()}
								</td>
							</tr>
						))}
					</tbody>
				</table>
			</div>

			<div className="flex justify-between items-center mt-4">
				<button
					onClick={() => setPage((p) => Math.max(0, p - 1))}
					disabled={data.pageInfo.first}
					className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 disabled:bg-gray-300 transition-colors"
				>
					Previous
				</button>
				<span className="text-gray-700">
					Page {data.pageInfo.currentPage + 1} of {data.pageInfo.totalPages}
				</span>
				<button
					onClick={() => setPage((p) => p + 1)}
					disabled={data.pageInfo.last}
					className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 disabled:bg-gray-300 transition-colors"
				>
					Next
				</button>
			</div>
		</div>
	);
};
